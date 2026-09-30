#!/bin/bash
cat > logs.txt <<'EOF'
error: something went wrong
warning: check your system
error: unable to connect
EOF

# Используем команду sed с регулярным выражением для замены строк,
# начинающихся с "error" на "Issue Detected"
sed 's/^error.*/Issue Detected/' logs.txt > updated_logs.txt

# Перезаписываем исходный файл обновленным содержимым
mv updated_logs.txt logs.txt