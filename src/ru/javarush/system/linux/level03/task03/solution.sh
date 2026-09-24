# Перезапуск службы cron
sudo systemctl restart cron

# Проверка статуса службы cron, чтобы убедиться, что она активна
sudo systemctl status cron

# Остановка службы cron
sudo systemctl stop cron

# Проверка всех завершённых с ошибкой служб
systemctl --failed

# Проверка состояния остановленной службы cron
systemctl status cron