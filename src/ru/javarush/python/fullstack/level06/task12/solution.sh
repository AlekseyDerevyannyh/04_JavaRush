# Создайте том с именем app_data
docker volume create app_data

# Запустите контейнер с Nginx, монтируя том app_data для хранения данных
docker run -d --name my_nginx -v app_data:/data nginx

# Запишите тестовый файл в том (например, index.html)
docker exec my_nginx sh -c 'echo "<h1>Welcome to My Test Site</h1>" > /data/index.html'

# Создайте бэкап данных тома app_data и сохраните его на хосте в виде архива
mkdir -p /path/to/backup
docker run --rm -v app_data:/data -v /path/to/backup:/backup \
    busybox tar czf /backup/app_data.tar.gz -C /data .

# Проверьте, что бэкап создан в текущей директории
ls /path/to/backup/
