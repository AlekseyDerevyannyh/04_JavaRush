# Создайте резервную копию тома my_volume и сохраните её в файл my_backup.tar.gz
docker run --rm \
  -v my_volume:/backup/my_volume:ro \
  -v "$(pwd)":/archive \
  -e BACKUP_FILENAME=my_backup.tar.gz \
  --entrypoint backup \
  offen/docker-volume-backup:v2

# Проверьте, что резервная копия создана
ls -l my_backup.tar.gz

# Восстановите том my_volume из резервной копии my_backup.tar.gz
docker run --rm \
  -v my_volume:/volume \
  -v "$(pwd)":/archive:ro \
  alpine tar -xzf /archive/my_backup.tar.gz -C /volume --strip-components=2 backup/my_volume

# Проверьте, что том восстановлен
docker run --rm -v my_volume:/volume alpine ls /volume
