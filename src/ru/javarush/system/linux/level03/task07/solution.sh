# Вывод логов сервиса `cron` за последние 24 часа и поиск строк с ключевым словом `ERROR`
journalctl -u cron --since "24 hours ago" | grep "ERROR"