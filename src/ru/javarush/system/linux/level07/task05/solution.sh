#!/bin/bash

# Создание корневой директории для сайта
sudo mkdir -p /var/www/mytestsite.com

# Создание главного файла index.html
echo "<h1>Welcome to MyTestSite.com!</h1>" | sudo tee /var/www/mytestsite.com/index.html

# Создание конфигурационного файла для виртуального хоста
sudo tee /etc/nginx/sites-available/mytestsite.com <<EOF
server {
    listen 80;
    server_name mytestsite.com www.mytestsite.com;
    root /var/www/mytestsite.com;
    index index.html;

    location / {
        try_files \$uri \$uri/ =404;
    }
}
EOF

# Активация конфигурации виртуального хоста
sudo ln -s /etc/nginx/sites-available/mytestsite.com /etc/nginx/sites-enabled/

# Проверка конфигурации Nginx на ошибки
sudo nginx -t

# Перезапуск Nginx
sudo systemctl restart nginx