# Создание сети bridge
docker network create --driver bridge my_bridge_network

# Запуск контейнера с Nginx и подключение к созданной сети
docker run -d --name my_nginx --network my_bridge_network nginx

# Запуск контейнера с Busybox и подключение к созданной сети
docker run -d --name my_busybox --network my_bridge_network busybox sleep 1000

# Проверка связи между контейнерами с использованием имени контейнера
docker exec my_busybox ping -c 4 my_nginx