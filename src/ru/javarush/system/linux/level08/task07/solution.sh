#!/bin/bash
cat > config.txt <<'EOF'
host=localhost
port=8080
mode=production
logfile=/var/log/app.log
EOF

# Используем команду sed для замены "localhost" на "127.0.0.1"
sed -i 's/localhost/127.0.0.1/' config.txt

# Используем команду sed для увеличения значения порта с 8080 до 8081
sed -i 's/8080/8081/' config.txt