# Создаем секрет для пароля базы данных PostgreSQL
docker secret create db_password ./db_password.txt

# Создаем сервис PostgreSQL с использованием созданного секрета
docker service create --name my_postgres --secret db_password \
    -e POSTGRES_PASSWORD_FILE=/run/secrets/db_password postgres
