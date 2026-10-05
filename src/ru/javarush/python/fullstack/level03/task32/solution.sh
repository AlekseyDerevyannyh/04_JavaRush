# Сборка и запуск образа для разработки
docker build --build-arg ENVIRONMENT=dev -t myapp:dev .
docker build --build-arg ENVIRONMENT=prod -t myapp:prod .

# Сборка и запуск образа для продакшн
docker run myapp:dev
docker run myapp:prod
