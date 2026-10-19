#!/bin/sh
# Получает сертификат Let's Encrypt до того, как nginx запустится с HTTPS:
# конфиг с ssl_certificate не стартует, пока файлов сертификата нет.
set -eu

: "${DOMAIN:?Задайте свой домен: docker run -e DOMAIN=mysite.ru ...}"
: "${EMAIL:?Задайте email для уведомлений об истечении сертификата: docker run -e EMAIL=admin@mysite.ru ...}"

WEBROOT=/var/www/certbot
CONF=/etc/nginx/conf.d/default.conf
mkdir -p "$WEBROOT"

if [ ! -f "/etc/letsencrypt/live/$DOMAIN/fullchain.pem" ]; then
    echo "Сертификата для $DOMAIN нет, получаю его у Let's Encrypt"

    # Временный конфиг: только HTTP и путь, по которому Let's Encrypt проверяет домен
    mv "$CONF" "$CONF.https"
    cat > "$CONF" <<CONF
    server {
        listen 80;
        server_name $DOMAIN;
        location /.well-known/acme-challenge/ {
            root $WEBROOT;
        }
    }
    CONF
    nginx

    # Получите сертификат через Certbot
    certbot certonly --webroot -w "$WEBROOT" \
        -d "$DOMAIN" --cert-name "$DOMAIN" \
        --email "$EMAIL" --agree-tos --no-eff-email --non-interactive \
        --deploy-hook "nginx -s reload"

    # Остановите временный nginx и верните конфиг с HTTPS
    nginx -s quit
    while [ -f /run/nginx.pid ]; do sleep 1; done
    mv "$CONF.https" "$CONF"
fi

# Автопродление: запустите cron
cron
