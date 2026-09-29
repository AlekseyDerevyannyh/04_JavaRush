#!/bin/bash
sudo mkdir -p /var/www/example.com
sudo mkdir -p /var/www/test.com
sudo chmod +r /var/www/example.com
sudo chmod +r /var/www/test.com

# 1. Настройка виртуального хоста для example.com
sudo tee /etc/nginx/sites-available/example.com <<EOF
server {
    listen 80;
    server_name example.com;

    root /var/www/example.com;
    index index.html;

    location / {
        try_files \$uri \$uri/ =404;
    }
}
EOF

# 2. Настройка виртуального хоста для test.com
sudo tee /etc/nginx/sites-available/test.com <<EOF
server {
    listen 80;
    server_name test.com;

    root /var/www/test.com;
    index index.html;

    location / {
        try_files \$uri \$uri/ =404;
    }
}
EOF

# 3. Активируйте оба виртуальных хоста
sudo ln -s /etc/nginx/sites-available/example.com /etc/nginx/sites-enabled/
sudo ln -s /etc/nginx/sites-available/test.com /etc/nginx/sites-enabled/

# 4. Проверьте конфигурацию Nginx
sudo nginx -t

# 5. Перезапустите Nginx
sudo systemctl restart nginx

# 6. Добавьте записи в /etc/hosts для тестирования
echo "127.0.0.1 example.com" | sudo tee -a /etc/hosts
echo "127.0.0.1 test.com" | sudo tee -a /etc/hosts

# 7. Проверьте доступность виртуальных хостов
curl -I "http://example.com"
curl -I "http://test.com"
