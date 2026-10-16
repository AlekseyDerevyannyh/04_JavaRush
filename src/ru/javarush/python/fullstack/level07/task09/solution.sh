# Запуск нескольких контейнеров
docker run -d --name my_mongo mongo
docker run -d --name my_redis redis

# Сбор метрик с использованием docker stats
docker stats --no-stream my_mongo
docker stats --no-stream my_redis

# Оптимизация потребляемых ресурсов
docker update --memory 512m my_mongo
docker update --cpus 0.5 my_redis
