# Запуск контейнера с Nginx
docker run -d --name my_nginx nginx

# Запуск контейнера с PostgreSQL
docker run -d --name my_postgres -e POSTGRES_PASSWORD=password postgres

# Мониторинг операций CPU и памяти
docker stats
