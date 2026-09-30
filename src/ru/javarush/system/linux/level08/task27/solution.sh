#!/bin/bash

# Загрузка файла data.log с использованием команды curl
curl -o data.log http://example.com/logs/data.log

# Поиск строк, содержащих слово "WARNING", и сохранение их в файл warnings.log
grep "WARNING" data.log > warnings.log

# Извлечение даты и сообщения из строк с предупреждениями и сохранение их в файл warnings_formatted.log
# Предполагается, что формат строки в warnings.log: "YYYY-MM-DD HH:MM:SS WARNING сообщение"
awk '{print $1, $2, $4}' > warnings_formatted.log
