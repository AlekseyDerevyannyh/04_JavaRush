# Создание сети
docker network create -d bridge webnet

# Запуск контейнера web с Nginx, подключенного к сети webnet
docker run -d --network webnet --name web nginx:latest bash -c "apt-get update && apt-get install -y iputils-ping && exec nginx -g 'daemon off;'"

# Запуск контейнера db с PostgreSQL, подключенного к сети webnet
docker run -d --network webnet --name db postgres

# Проверка связи с помощью ping
docker exec web ping -c 4 db
