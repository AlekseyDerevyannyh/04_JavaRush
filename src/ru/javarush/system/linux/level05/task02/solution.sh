#!/bin/bash

# Создаем пользователя testuser
sudo adduser testuser

# Устанавливаем пароль для пользователя testuser длиной не менее 8 символов
echo "testuser:12345678" | sudo chpasswd

# Создаем файл secure_file.txt в домашней директории пользователя testuser
sudo touch /home/testuser/secure_file.txt

# Устанавливаем права доступа, чтобы только владелец файла мог читать и записывать его
sudo chown testuser /home/testuser/secure_file.txt
sudo chmod 600 /home/testuser/secure_file.txt