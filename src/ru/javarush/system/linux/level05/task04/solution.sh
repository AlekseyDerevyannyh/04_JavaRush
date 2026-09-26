#!/bin/bash

# Проверка, установлен ли ufw, и установка, если отсутствует
sudo apt update
sudo apt install -y ufw

# Включение брандмауэра
sudo ufw enable

# Разрешение трафика для SSH (порт 22)
sudo ufw allow 22

# Разрешение трафика для HTTP (порт 80)
sudo ufw allow 80

# Запрет всех остальных подключений
sudo ufw default deny incoming

# Вывод текущих правил брандмауэра
sudo ufw status