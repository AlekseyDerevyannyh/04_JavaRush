#!/bin/bash

# Добавление статического маршрута для подсети 10.10.20.0/24 через шлюз 192.168.1.254 и интерфейс eth0
sudo ip route add 10.10.20.0/24 via 192.168.1.254 dev eth0

# Удаление ранее добавленного маршрута
sudo ip route del 10.10.20.0/24 via 192.168.1.254

# Вывод списка всех портов в состоянии "Listening" и сохранение результата в файл listening_ports.txt
ss -tuna | grep LISTEN > listening_ports.txt