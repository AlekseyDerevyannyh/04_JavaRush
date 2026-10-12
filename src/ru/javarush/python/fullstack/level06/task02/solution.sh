# Создаем директорию  /home/user/website
mkdir -p /home/user/website

# Запустите контейнер с Nginx, смонтировав локальную директорию /home/user/website
# в директорию /usr/share/nginx/html контейнера
docker run -d --name my_nginx -v /home/user/website:/usr/share/nginx/html nginx

# Проверьте, что контейнер запущен и директория смонтирована
docker inspect my_nginx