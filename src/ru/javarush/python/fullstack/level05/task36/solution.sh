# Запустите контейнер с Nginx, смонтировав сертификаты и ключи для использования TLS
docker run -d -p 443:443 --name nginx_tls \
    -v "$(pwd)/docker/nginx.conf:/etc/nginx/nginx.conf:ro" \
    -v "$(pwd)/docker/key.pem:/etc/nginx/key.pem:ro" \
    -v "$(pwd)/docker/cert.pem:/etc/nginx/cert.pem:ro" \
    nginx
