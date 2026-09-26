#!/bin/bash

# Установка UFW с использованием пакетного менеджера
sudo apt-get update  # Обновляем список пакетов
sudo apt-get install -y ufw  # Устанавливаем UFW

# Включение UFW
echo "y" | sudo ufw enable

# Проверка статуса UFW
sudo ufw status