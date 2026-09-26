#!/bin/bash

# Создаем файл file_for_acl.txt
touch file_for_acl.txt

# Устанавливаем ACL для пользователя user1 с правами на чтение и запись
sudo setfacl -m u:user1:rw file_for_acl.txt

# Проверяем установленные права с использованием команды getfacl
getfacl file_for_acl.txt