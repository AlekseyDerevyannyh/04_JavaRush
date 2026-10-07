# Запуск контейнеров с помощью Docker Compose
docker compose up -d

# Проверка связи между веб-сервером и базой данных
docker compose exec web ping -c 4 db
docker compose exec db ping -c 4 web
