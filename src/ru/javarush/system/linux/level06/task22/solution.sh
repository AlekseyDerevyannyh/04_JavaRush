#!/bin/bash

# Скопируйте содержимое домашней директории на удалённый сервер с помощью rsync
rsync -avz -e "ssh -i ~/.ssh/id_rsa" ~ backup_user@192.168.1.100:/backups/home_backup