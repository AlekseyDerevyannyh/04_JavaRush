# Используем docker compose logs для получения логов всех запущенных контейнеров
logs=$(docker compose logs)

# Выводим логи всех контейнеров
echo "$logs"

# Ищем в логах строку, которая подтверждает успешный запуск сервера Nginx
if echo "$logs" | grep -q "nginx started"; then
    echo "Nginx server has successfully started."
else
    echo "Nginx server start confirmation not found in logs."
fi