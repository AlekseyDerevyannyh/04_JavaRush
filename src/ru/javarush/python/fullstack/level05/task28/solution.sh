# Инициализация Docker Swarm
docker swarm init

# Создание сети
docker network create -d overlay --attachable my_overlay_network

# Развертывание стека с помощью Docker Compose
docker stack deploy -c docker-compose.yml mystack

# Проверка развернутых сервисов
docker service ls
