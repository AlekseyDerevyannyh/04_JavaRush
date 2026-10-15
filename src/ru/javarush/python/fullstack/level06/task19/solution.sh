# Создаем директорию на хосте для монтирования, если она не существует
mkdir -p $(pwd)/data

# Записываем тестовый файл в директорию на хосте
echo "test file" > $(pwd)/data/testFile

# Запускаем контейнер с монтированной директорией
docker run -d --name my_nginx -v $(pwd)/data:/app nginx

# Проверяем содержимое смонтированной директории внутри контейнера
docker exec -it my_nginx ls /app

# Выводим содержимое тестового файла внутри контейнера
docker exec -it my_nginx cat /app/testFile
