#!/bin/bash

# 1. Создайте директорию для сайта
sudo mkdir -p /var/www/mywebsite

# 2. Переместите файл index.html в эту директорию
sudo mv index.html /var/www/mywebsite/

# 3. Настройте веб-сервер Nginx
sudo tee /etc/nginx/sites-available/mywebsite <<EOF
server {
    listen 80;
    server_name localhost;

    root /var/www/mywebsite;
    index index.html;

    location / {
        try_files \$uri \$uri/ =404;
    }
}
EOF

# 4. Активируйте конфигурацию, создав символическую ссылку
sudo ln -s /etc/nginx/sites-available/mywebsite /etc/nginx/sites-enabled/

# 5. Проверьте конфигурацию на ошибки
sudo nginx -t

# 6. Перезапустите сервер Nginx
sudo systemctl restart nginx

# 7. Уведомление для проверки
echo "Откройте в браузере http://localhost для проверки сайта."
xdg-open "http://localhost"
