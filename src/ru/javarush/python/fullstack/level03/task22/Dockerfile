# Используем базовый образ Ubuntu
FROM ubuntu:latest

# Обновляем список пакетов в пакетном менеджере
RUN apt-get update && \
    apt-get install -y curl git && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
