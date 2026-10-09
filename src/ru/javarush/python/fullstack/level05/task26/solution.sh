# Инициализируем Docker Swarm
docker swarm init

# Создаем overlay сеть для связи между сервисами
docker network create --driver overlay my_overlay_network

# Создаем сервис веб-сервера Nginx, подключаем его к overlay сети и пробрасываем порт 80 на 8080 хоста
docker service create --name webserver --network my_overlay_network -p 8080:80 nginx

# Создаем сервис базы данных PostgreSQL, подключаем его к overlay сети и задаем пароль для пользователя root
docker service create --name database --network my_overlay_network -e POSTGRES_PASSWORD=mypassword postgres
