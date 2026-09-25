#!/bin/bash

# Создание конфигурации для локального сервера в файле ~/.ssh/config
CONFIG_FILE="$HOME/.ssh/config"
HOST_ALIAS="mylocalserver"
HOST_NAME="localhost"
USER_NAME=$(whoami)
KEY_PATH="$HOME/.ssh/id_rsa"

# Проверка существования файла конфигурации и создание, если отсутствует
if [ ! -f "$CONFIG_FILE" ]; then
  touch "$CONFIG_FILE"
fi
chmod 600 "$CONFIG_FILE"

# Добавление конфигурации для локального сервера
echo "Настройка конфигурации SSH..."
{
  echo "Host $HOST_ALIAS"
  echo "    HostName $HOST_NAME"
  echo "    User $USER_NAME"
  echo "    IdentityFile $KEY_PATH"
} >> "$CONFIG_FILE"

# Подключение к серверу с использованием нового имени хоста
echo "Подключение к $HOST_ALIAS..."
ssh $HOST_ALIAS