# Инициализация Docker Swarm
docker swarm init

# Создание сервиса my_web с 3 репликами
docker service create --name my_web --replicas 3 -p 8080:80 nginx

# Масштабирование сервиса my_web до 5 реплик
docker service scale my_web=5
