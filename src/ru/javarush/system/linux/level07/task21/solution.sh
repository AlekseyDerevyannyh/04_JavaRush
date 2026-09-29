#!/bin/bash

# 1. Установите Nginx
sudo apt update
sudo apt install -y nginx

# 2. Проверьте, что сервер установлен и работает
nginx -v
sudo systemctl status nginx
sudo ss -tlnp | grep :80

# 3. Установите Certbot и плагин для Nginx
sudo apt install -y certbot python3-certbot-nginx

# 4. Убедитесь, что Certbot установлен
certbot --version