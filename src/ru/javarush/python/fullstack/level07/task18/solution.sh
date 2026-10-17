# Запуск контейнера с именем my_container
docker run -d --name my_container -p 8080:80 nginx

# Просмотр логов контейнера my_container
docker logs my_container
