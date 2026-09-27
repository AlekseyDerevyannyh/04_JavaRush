#!/bin/bash

# Проверка, установлен ли UFW
command -v ufw 2>/dev/null || sudo apt update && sudo apt install -y ufw

# Включение UFW
sudo ufw enable

# Очистка существующих правил
sudo ufw reset
sudo ufw enable

# Разрешение SSH (порт 22)
sudo ufw allow 22

# Разрешение HTTP (порт 80)
sudo ufw allow 80

# Проверка текущего состояния UFW
sudo ufw status