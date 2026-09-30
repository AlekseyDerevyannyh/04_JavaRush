#!/bin/bash

FILE=exchange_rates.json
# Отправляем GET-запрос к API и следуем за редиректами (опция -L)
curl -L -X GET "https://api.exchangerate-api.com/v4/latest/USD" > $FILE

[ -s $FILE ] && echo "Данные от API успешно получены и записаны в файл $FILE" || echo "Ошибка получения данных от API"
