# Создаем несколько томов
docker volume create volume1
docker volume create volume2

# Создаем и запускаем контейнеры, использующие эти тома
docker run -d --name my_nginx1 -v volume1:/data nginx
docker run -d --name my_nginx2 -v volume2:/data nginx

# Останавливаем контейнеры
docker stop my_nginx1 my_nginx2

# Удаляем контейнеры
docker rm my_nginx1 my_nginx2

# Очищаем неиспользуемые тома
docker volume prune

# Подтверждение удаления томов
echo "Неиспользуемые тома успешно удалены."