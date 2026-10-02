#В контейнере с именем db_container создайте новый файл backup.sql в директории /data.
docker run -d --name db_container mysql
docker exec -d db_container touch /data/backup.sql
