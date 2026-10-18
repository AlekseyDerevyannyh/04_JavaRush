FROM nginx:latest

# Certbot — клиент Let's Encrypt; cron — чтобы продлевать сертификат по расписанию.
# Задание cron из пакета certbot убираем: продление настроено своим файлом ниже
RUN apt-get update && \
    apt-get install -y --no-install-recommends certbot cron && \
    rm -f /etc/cron.d/certbot && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Конфиг Nginx кладём шаблоном: при старте образ nginx сам подставит в него ${DOMAIN}
COPY ./default.conf /etc/nginx/templates/default.conf.template

# Скрипты из /docker-entrypoint.d/ образ nginx выполняет ДО запуска nginx:
# этот получает сертификат, если его ещё нет, и запускает cron
COPY ./letsencrypt.sh /docker-entrypoint.d/40-letsencrypt.sh
RUN chmod +x /docker-entrypoint.d/40-letsencrypt.sh

# Задание cron на автоматическое продление сертификата
COPY ./certbot-renew /etc/cron.d/certbot-renew
RUN chmod 644 /etc/cron.d/certbot-renew

# Сертификаты и настройки Certbot хранятся в томе и переживают пересоздание контейнера
VOLUME /etc/letsencrypt

EXPOSE 80 443

# Указываем точку входа для контейнера
CMD ["nginx", "-g", "daemon off;"]
