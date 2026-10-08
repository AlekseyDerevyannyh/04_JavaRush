# Создание сети macvlan
docker network create --driver macvlan \
    --subnet=192.168.1.0/24 \
    --gateway=192.168.1.1 \
    -o parent=eth0 my_macvlan_network

# Запуск контейнера с Nginx и подключение к сети macvlan
docker run -d --network my_macvlan_network --name my_nginx nginx

# Запуск контейнера с Busybox и подключение к сети macvlan
docker run -d --network my_macvlan_network --name my_busybox busybox sleep 1000

# Проверка связи между контейнерами с помощью команды ping
docker exec my_busybox ping -c4 my_nginx

# Проверка сети
docker network inspect my_macvlan_network
