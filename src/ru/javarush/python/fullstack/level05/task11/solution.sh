# Создание пользовательской сети с драйвером bridge.
docker network create --driver bridge my_bridge_network

# Запуск контейнера с Nginx, подключенного к пользовательской сети.
docker run -d --name my_nginx --network my_bridge_network nginx

# Запуск контейнера с Busybox, подключенного к пользовательской сети.
docker run -d --name my_busybox --network my_bridge_network busybox sleep 1000

# Тестирование связи по имени хоста со стороны контейнера Busybox.
docker exec my_busybox ping -c 4 my_nginx