# Создать том с именем db_backup
docker volume create db_backup

# Запуск временного контейнера с использованием тома db_backup
docker run --rm -d --name tmp_container -v db_backup busybox

# Получение информации о томе db_backup
docker volume inspect db_backup