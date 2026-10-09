# Инициализация Docker Swarm
docker swarm init

# Загрузите последний образ Nginx
docker pull nginx:latest

# Обновите сервис my_web, чтобы он использовал последнюю версию образа Nginx
docker service update \
    --image nginx:latest \
    --update-order start-first \
    --health-cmd "curl -f http://localhost/ || exit 1" \
    --health-interval 10s \
    --health-timeout 5s \
    --health-retries 3 \
    --health-start-period 15s \
    my_web
