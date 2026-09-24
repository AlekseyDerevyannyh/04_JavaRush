#!/bin/bash

# Делаем скрипт cpu_alert.sh исполняемым
chmod +x cpu_alert.sh

# Добавление задачи в crontab для выполнения скрипта каждые 10 минут
(crontab -l 2>/dev/null; echo "*/10 * * * * cpu_alert.sh") | crontab -