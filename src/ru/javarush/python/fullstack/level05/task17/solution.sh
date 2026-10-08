# Создание пользовательской сети типа bridge с именем my_bridge_network
docker network create --driver bridge my_bridge_network

# Запуск контейнера с Nginx и подключение его к my_bridge_network
docker run -d --network my_bridge_network --name my_nginx nginx

# Запуск контейнера с Busybox и подключение его к my_bridge_network
docker run -d --network my_bridge_network --name my_busybox busybox sleep 1000

# Проверка связи между контейнерами с помощью команды ping
docker exec my_busybox ping -c4 my_nginx