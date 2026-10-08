# Создаём самоподписанный сертификат
openssl req -x509 -nodes \
  -days 365 \
  -newkey rsa:2048 \
  -keyout nginx.key \
  -out nginx.crt \
  -subj "/CN=localhost"

# Создаём конфигурацию Nginx
cat > nginx.conf <<'EOF'
events {}

http {
    server {
        listen 80;

        location / {
            root /usr/share/nginx/html;
            index index.html;
        }
    }

    server {
        listen 443 ssl;

        ssl_certificate     /etc/nginx/nginx.crt;
        ssl_certificate_key /etc/nginx/nginx.key;

        location / {
            root /usr/share/nginx/html;
            index index.html;
        }
    }
}
EOF

# Запуск контейнера с пробросом портов для HTTP и HTTPS
docker run -d \
  --name nginx_container \
  -p 8080:80 \
  -p 8443:443 \
  -v "$(pwd)/nginx.conf:/etc/nginx/nginx.conf:ro" \
  -v "$(pwd)/nginx.crt:/etc/nginx/nginx.crt:ro" \
  -v "$(pwd)/nginx.key:/etc/nginx/nginx.key:ro" \
  nginx
