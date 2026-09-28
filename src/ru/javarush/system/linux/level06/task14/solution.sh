#!/bin/bash

# 1. Определите подключенное устройство
blkid

# 2. Определите тип файловой системы устройства

FILE_SYSTEM=$(blkid -o value -s TYPE /dev/sdb)

# 3. Смонтируйте устройство с указанием типа файловой системы
sudo mkdir -p /mnt/usb
sudo mount -t $FILE_SYSTEM /dev/sdb /mnt/usb

# 4. Проверьте содержимое точки монтирования
ls /mnt/usb