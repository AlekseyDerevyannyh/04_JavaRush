#!/bin/bash

# Удаление строк, содержащих слово "Linux", и вывод результата
cat > example.txt <<'EOF'
Hello world!
Welcome to Linux.
Linux is awesome.
EOF

sed '/Linux/d' example.txt