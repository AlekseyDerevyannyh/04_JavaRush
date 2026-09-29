#!/bin/bash

# Установите веб-сервер Nginx
sudo apt update
sudo apt install -y nginx

# Запустите Nginx и проверьте его статус
sudo systemctl start nginx
sudo systemctl status nginx

# Откройте браузер и проверьте http://localhost
echo "Перейдите в браузере по адресу http://localhost, чтобы увидеть стандартную страницу Nginx."
