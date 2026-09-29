#!/bin/bash

# 1. Создайте корневую директорию для первого сайта и добавьте index.html
sudo mkdir -p /var/www/site1
echo "<h1>Welcome to Site 1</h1>" | sudo tee /var/www/site1/index.html

# 2. Создайте корневую директорию для второго сайта и добавьте index.html
sudo mkdir -p /var/www/site2
echo "<h1>Welcome to Site 2</h1>" | sudo tee /var/www/site2/index.html

# 3. Создайте конфигурационный файл для первого виртуального хоста
sudo tee /etc/nginx/sites-available/site1.local <<EOF
server {
    listen 80;
    server_name site1.local;

    root /var/www/site1;
    index index.html;

    location / {
        try_files \$uri \$uri/ =404;
    }
}
EOF

# 4. Создайте конфигурационный файл для второго виртуального хоста
sudo tee /etc/nginx/sites-available/site2.local <<EOF
server {
    listen 80;
    server_name site2.local;

    root /var/www/site2;
    index index.html;

    location / {
        try_files \$uri \$uri/ =404;
    }
}
EOF

# 5. Активируйте оба виртуальных хоста
sudo ln -s /etc/nginx/sites-available/site1.local /etc/nginx/sites-enabled/
sudo ln -s /etc/nginx/sites-available/site2.local /etc/nginx/sites-enabled/

# 6. Проверьте конфигурацию на ошибки
sudo nginx -t

# 7. Перезапустите сервер Nginx
sudo systemctl restart nginx

# 8. Добавьте записи в /etc/hosts для тестирования
echo "127.0.0.1 site1.local" | sudo tee -a /etc/hosts
echo "127.0.0.1 site2.local" | sudo tee -a /etc/hosts

# 9. Проверьте работу сайтов с помощью curl
curl "http://site1.local"
curl "http://site2.local"
