#!/bin/bash

# 1. Обновите систему
sudo apt-get update
sudo apt-get upgrade -y

# 2. Установите Certbot и соответствующий плагин для веб-сервера

# Для Nginx
sudo apt-get install certbot python3-certbot-nginx

# Для Apache
sudo apt-get install certbot python3-certbot-apache

# 3. Убедитесь, что Certbot установлен
certbot --version
