# Создаем каталог для хранения резервной копии, если он не существует
mkdir -p /backup

# Создаем резервную копию тома my_volume, используя контейнер busybox
docker run --rm -v my_volume:/volume -v /backup:/backup busybox tar czf /backup/my_volume_backup.tar.gz -C /volume .

# Восстанавливаем том my_volume из ранее созданной резервной копии
docker run --rm -v my_volume:/volume -v /backup:/backup busybox tar xzf /backup/my_volume_backup.tar.gz -C /volume
