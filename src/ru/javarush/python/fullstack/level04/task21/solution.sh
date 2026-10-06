# Запуск для разработки
docker compose --env-file .env.development up -d

# Запуск для продакшена
docker compose --env-file .env.production up -d