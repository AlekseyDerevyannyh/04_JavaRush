# Инициализация Docker Swarm
docker swarm init

# Создание overlay-сети
docker network create -d overlay my_overlay_network

# Развертывание сервиса с контейнером Nginx в overlay-сети
docker service create --name my_service --network my_overlay_network nginx

# Проверка работы сервиса
docker service ls
