# Запуск контейнера с именем my_service
docker run -d --name my_service -p 8080:80 nginx

# Используем команду docker logs с флагом -f для отслеживания логов в режиме реального времени
docker logs -f my_service
