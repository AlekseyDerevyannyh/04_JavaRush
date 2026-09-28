#!/bin/bash

# 1. Создайте файловую систему ext4 на диске /dev/sdb
sudo mkfs.ext4 /dev/sdb

# 2. Выведите информацию о диске /dev/sdb и его файловой системе
blkid /dev/sdb