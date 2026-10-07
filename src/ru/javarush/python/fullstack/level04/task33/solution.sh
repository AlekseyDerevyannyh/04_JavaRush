# Запуск контейнеров
docker compose up -d

# Пауза для ожидания запуска контейнера
sleep 10

# Подключение и проверка данных
docker compose exec db ls -l /var/lib/postgresql/data
docker compose exec db psql -U exampleuser -d exampledb -c "CREATE TABLE IF NOT EXISTS test_table (id SERIAL PRIMARY KEY, name TEXT);"
docker compose exec db psql -U exampleuser -d exampledb -c "INSERT INTO test_table (name) VALUES ('test_entry');"
docker compose restart
sleep 10
docker compose exec db psql -U exampleuser -d exampledb -c "SELECT * FROM test_table;" | grep -q "test_entry" && echo "OK" || (echo "FAIL"; exit 1)

# Остановка контейнеров после проверки
docker compose down