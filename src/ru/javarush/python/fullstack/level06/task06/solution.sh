# Создайте том с именем logs_volume для хранения логов
docker volume create logs_volume

# Запустите контейнер (например, Nginx), монтируя том logs_volume
docker run -d --name my_nginx -v logs_volume:/var/log/nginx nginx

# Остановите контейнер
docker stop my_nginx

# Удалите контейнер
docker rm my_nginx

# Удалите том logs_volume
docker volume rm logs_volume

# Проверьте, что том больше не существует
docker volume ls
