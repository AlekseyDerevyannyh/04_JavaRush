# Создайте секрет для пароля базы данных PostgreSQL
echo "mysecretpassword" | docker secret create db_password -

# Создайте overlay-сеть для сервиса PostgreSQL, если она не создана (сервисы Swarm подключаются только к overlay-сетям)
docker network create --driver overlay my_overlay_network

# Создайте сервис PostgreSQL, используя секрет для пароля
docker service create --name postgres --secret db_password \
    --network my_overlay_network \
    -e POSTGRES_PASSWORD_FILE=/run/secrets/db_password postgres
