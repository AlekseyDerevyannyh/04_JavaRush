#!/bin/bash

# Добавление задания в crontab для выполнения скрипта ежедневно в 01:00
echo "0 1 * * * backup.sh" | crontab -