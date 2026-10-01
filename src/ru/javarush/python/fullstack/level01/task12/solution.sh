# Создание нового Docker тома с именем data_volume
docker volume create data_volume
# Просмотр информации о созданном томе data_volume
docker volume inspect data_volume
# Запуск контейнера и монтирование тома data_volume по пути /data
docker run -d --name my_container -v data_volume:/data nginx
#Удаление контейнера my_container и тома data_volume
docker stop my_container
docker rm my_container
docker volume rm data_volume
