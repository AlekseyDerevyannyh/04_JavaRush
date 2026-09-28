#!/bin/bash

# Создаем точку монтирования /mnt/testdisk
mkdir -p /mnt/testdisk

# Монтируем диск /dev/sdb в точку монтирования /mnt/testdisk
sudo mount /dev/sdb /mnt/testdisk

# Проверяем, что диск /dev/sdb смонтирован, с помощью команды df -h
df -h | grep "/mnt/testdisk"

# Определяем UUID диска /dev/sdb с помощью команды blkid
UUID=$(blkid -s UUID -o value /dev/sdb)
FSTYPE=$(blkid -o value -s TYPE /dev/sdb)

# Создаем резервную копию файла fstab перед внесением изменений
cp /etc/fstab /etc/fstab.backup

# Добавляем запись о диске в /etc/fstab для автоматического монтирования
echo "UUID=$UUID /mnt/testdisk $FSTYPE defaults 0 0" >> /etc/fstab

# Выводим содержимое файла /etc/fstab для проверки
echo "Содержимое файла /etc/fstab после добавления записи:"
cat /etc/fstab

# Тестируем автоматическое монтирование (эмулируем перезапуск системы)
sudo umount /mnt/testdisk
sudo mount -a

# Проверяем, что диск снова смонтирован после команды mount -a
df -h | grep "/mnt/testdisk"