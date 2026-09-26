#!/bin/bash

# Создаем группу developers
sudo groupadd developers

# Создаем пользователей dev1 и dev2
sudo adduser dev1
sudo adduser dev2
sudo usermod -aG developers dev1
sudo usermod -aG developers dev2

# Создаем директорию /shared_folder
sudo mkdir /shared_folder

# Устанавливаем владельцем группы директории /shared_folder группу developers
sudo chown :developers /shared_folder

# Настраиваем права доступа к директории /shared_folder
sudo chmod 070 /shared_folder