#!/bin/bash

# Создаем файл acl_reset.txt
touch acl_reset.txt

# Устанавливаем ACL права для пользователей user1 и user2
# Даем пользователям права на чтение и запись
sudo setfacl -m u:user1:rw acl_reset.txt
sudo setfacl -m u:user2:rw acl_reset.txt

# Удаляем все ACL права для файла acl_reset.txt
sudo setfacl -b acl_reset.txt

# Проверяем текущие права файла с помощью команды getfacl
getfacl acl_reset.txt