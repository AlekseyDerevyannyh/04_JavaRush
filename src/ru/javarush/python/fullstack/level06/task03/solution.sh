# Создайте том с именем pg_data для хранения данных PostgreSQL
docker volume create pg_data

# Запустите контейнер с PostgreSQL, монтируя том pg_data в директорию /var/lib/postgresql/data контейнера
docker run -d --name my_postgres -e POSTGRES_PASSWORD=mypassword -v pg_data:/var/lib/postgresql/data postgres
