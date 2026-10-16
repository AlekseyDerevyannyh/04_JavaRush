# Запуск контейнера с Nginx
docker run -d --name nginx_container -p 8080:80 nginx > /dev/null

# Запуск контейнера с PostgreSQL
docker run -d --name postgres_container \
    -e POSTGRES_PASSWORD=mysecretpassword \
    -p 5432:5432 \
    postgres > /dev/null

# Вывод имени контейнера, процента использования CPU и памяти.
docker stats --format "table {{.Name}}\t{{.CPUPerc}}\t{{.MemPerc}}"
