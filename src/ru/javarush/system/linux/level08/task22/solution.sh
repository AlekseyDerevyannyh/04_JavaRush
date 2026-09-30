#!/bin/bash

# 1. Установите текстовый редактор nano
set -e
sudo yum install nano
echo "nano успешно установлен!"

# 2. Очистите временные файлы и кэш
sudo rm -rf /tmp/*
sudo yum clean all
