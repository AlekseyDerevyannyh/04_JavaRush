# Создание новой сети с драйвером bridge
docker network create --driver bridge my_bridge_network

# Запуск контейнера с Nginx и подключение его к сети
docker run -d --name my_nginx nginx
docker network connect my_bridge_network my_nginx
# Запуск контейнера с Redis и подключение его к сети
docker run -d --name my_redis redis
docker network connect my_bridge_network my_redis
# Проверка работы контейнеров в сети
docker network inspect my_bridge_network
