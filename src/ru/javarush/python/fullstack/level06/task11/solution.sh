# Создайте том с именем config_volume
docker volume create config_volume

# Запустите временный контейнер и запишите в том файл конфигурации
docker run --rm -v config_volume:/app \
    busybox sh -c "echo 'configuration data' > /app/config.txt"

# Запустите еще один временный контейнер, чтобы проверить содержимое тома с помощью команды ls
docker run --rm -v config_volume:/app busybox ls /app

# Вывод содержимого файла конфигурации
docker run --rm -v config_volume:/app busybox cat /app/config.txt
