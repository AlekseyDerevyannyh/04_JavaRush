#!/bin/bash

# Обновление списка доступных пакетов
sudo apt-get update

# Полное обновление системы, включая все пакеты и их зависимости
sudo apt-get dist-upgrade

# Удаление всех неиспользуемых пакетов и зависимостей
sudo apt-get autoremove
sudo apt-get clean
