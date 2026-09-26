#!/bin/bash

# Очистка существующих правил
iptables -F
iptables -X

# Установка политики по умолчанию: блокировать все входящие соединения
iptables -P INPUT DROP
iptables -P FORWARD DROP
iptables -P OUTPUT ACCEPT

# Разрешение входящих соединений для порта SSH (22)
sudo iptables -A INPUT -p tcp --dport 22 -j ACCEPT

# Разрешение входящих соединений для порта HTTP (80)
sudo iptables -A INPUT -p tcp --dport 80 -j ACCEPT

# Разрешение входящих соединений для порта HTTPS (443)
sudo iptables -A INPUT -p tcp --dport 443 -j ACCEPT

# Разрешение входящих соединений от localhost (для корректной работы системы)
sudo iptables -A INPUT -i lo -j ACCEPT

# Разрешение входящих соединений для уже установленных соединений
sudo iptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT

# Вывод текущих правил iptables
iptables -L -v

# Сохранение настроек iptables (для систем с утилитой iptables-persistent)
iptables-save > /etc/iptables/rules.v4

# Для систем с утилитой iptables-persistent также необходимо сохранять IPv6 правила, если используются
if [ -f /etc/iptables/rules.v6 ]; then
    ip6tables-save > /etc/iptables/rules.v6
fi