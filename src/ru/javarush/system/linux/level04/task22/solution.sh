#!/bin/bash

# Устанавливаем SSH-сервер, если он не установлен
sudo apt update
sudo apt install -y openssh-server

# Включаем и запускаем SSH-сервер
sudo systemctl enable ssh
sudo systemctl start ssh

# Проверяем статус SSH-сервера, чтобы убедиться, что он работает
sudo systemctl status ssh

# Получаем имя текущего пользователя
CURRENT_USER=$(whoami)

# Подключение к локальному SSH-серверу
echo "Подключение к SSH-серверу на 127.0.0.1 от имени пользователя $CURRENT_USER..."
ssh "$CURRENT_USER@127.0.0.1"