# Создайте том с именем my_data_volume
docker volume create my_data_volume

# Запустите контейнер с Nginx, смонтировав том my_data_volume в директорию /data контейнера
docker run -d --name my_nginx -v my_data_volume:/data nginx

# Проверьте, что том подключен к контейнеру
docker inspect my_nginx

# Проверьте, что том создан
docker volume ls