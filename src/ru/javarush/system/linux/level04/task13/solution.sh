#!/bin/bash

# Установка SSH-клиента
sudo apt update
sudo apt install openssh-client

# Проверяем текущую версию установленного SSH-клиента и выводим ее на экран
echo "Текущая версия SSH-клиента:"
ssh -V