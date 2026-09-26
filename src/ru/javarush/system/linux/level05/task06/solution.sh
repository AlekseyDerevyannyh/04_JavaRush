#!/bin/bash

# Убедиться, что UFW установлен и активен
sudo ufw status

# Разрешение доступа к SSH (порт 22)
sudo ufw allow 22

# Разрешение доступа к веб-серверу (порт 80)
sudo ufw allow 80

# Блокировка входящего трафика на порт 8080
sudo ufw deny 8080

# Проверка текущих правил UFW
sudo ufw status