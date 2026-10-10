# Убедитесь, что сеть webnet создана
docker network ls | grep webnet

# Запуск контейнера web с Nginx, подключенного к сети webnet
docker run -d --name web --network webnet nginx

# Запуск контейнера db с PostgreSQL, подключенного к сети webnet
docker run -d --name db --network webnet postgres

# Установка утилиты nslookup в контейнере web
docker exec -it web apt-get install -y dnsutils


# Проверка DNS с помощью nslookup
docker exec -it web nslookup db

# Проверьте, что оба контейнера подключены к одной и той же сети
docker network inspect webnet
