#!/bin/bash

# 1. Найдите UUID устройства
blkid /dev/sdb
UUID=$(blkid -o value -s UUID /dev/sdb)
FSTYPE=$(blkid -o value -s TYPE /dev/sdb)

# 2. Создайте точку монтирования
sudo mkdir -p /mnt/usb-auto

# 3. Отредактируйте файл /etc/fstab и добавьте строку (замените <ваш_UUID> и ext4 на свои значения)
echo "UUID=$UUID /mnt/usb-auto $FSTYPE defaults 0 2" | sudo tee -a /etc/fstab

# 4. Протестируйте настройки
sudo mount -a

# 5. Проверьте содержимое точки монтирования
ls /mnt/usb-auto

# 6. Перезагрузите систему и проверьте монтирование
reboot
ls /mnt/usb-auto