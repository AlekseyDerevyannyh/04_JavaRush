# Создайте именованный том:
docker volume create app_data

# Запустите контейнер с монтированием тома:
docker run -d --name app_container -v app_data:/data nginx
