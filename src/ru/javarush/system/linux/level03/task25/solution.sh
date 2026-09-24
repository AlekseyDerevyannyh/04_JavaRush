#!/bin/bash

# Указание веб-сайта для проверки
WEBSITE="example.com"

# Выполнение команды ping с минимальным количеством запросов (-c 1)
if ping -c 1 $WEBSITE &> /dev/null; then
    IS_WEBSITE_AVAILABLE=0
else
    IS_WEBSITE_AVAILABLE=1
fi

# Проверка результата выполнения команды ping
if [ $IS_WEBSITE_AVAILABLE -eq 0 ]; then
    echo "Сайт доступен"
else
    echo "Сайт недоступен"
fi