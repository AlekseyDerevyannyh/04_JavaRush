# Запустите контейнер с Nginx, смонтировав файл конфигурации в контейнер
docker run -d --name my_nginx -v $(pwd)/host/nginx.conf:/etc/nginx/nginx.conf nginx
