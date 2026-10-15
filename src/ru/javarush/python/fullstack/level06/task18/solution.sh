# Запустите контейнер, смонтировав директорию с хоста в контейнер с правами только для чтения
docker run -d --name my_nginx --mount type=bind,source=/data,target=/app,readonly nginx
