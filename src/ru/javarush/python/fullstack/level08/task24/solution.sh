# Постройте Docker образ:
docker build -t nginx-ssl .

# Запустите Docker контейнер (домен и email передайте переменными окружения DOMAIN и EMAIL):
docker run -d -p 80:80 -p 443:443 \
    -e DOMAIN="$DOMAIN" -e EMAIL="$EMAIL" \
    -v letsencrypt:/etc/letsencrypt \
    --name nginx-ssl nginx-ssl

# Дождитесь, пока nginx начнёт отвечать по HTTPS с полученным сертификатом:
until docker exec nginx-ssl curl -sf -o /dev/null --resolve "$DOMAIN:443:127.0.0.1" "https://$DOMAIN/"; do
    if [ "$(docker inspect -f '{{.State.Running}}' nginx-ssl)" != "true" ]; then
        echo "Сертификат получить не удалось:"
        docker logs nginx-ssl
        exit 1
    fi
    sleep 2
done

# Проверьте, что автоматическое продление сертификата сработает:
docker exec nginx-ssl certbot renew --dry-run --no-random-sleep-on-renew
