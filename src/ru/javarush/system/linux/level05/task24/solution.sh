#!/bin/bash

# Создаем каталог /project_dir
sudo mkdir /project_dir

# Настраиваем полный доступ (rwx) для пользователя user1
sudo setfacl -m u:user1:rwx /project_dir

# Настраиваем права только чтения (r--) для пользователя user2
sudo setfacl -m u:user2:r-- /project_dir

# Настраиваем права по умолчанию: полный доступ для user1
sudo setfacl -d -m u:user1:rwx /project_dir

# Настраиваем права по умолчанию: права только чтения для user2
sudo setfacl -d -m u:user2:r-- /project_dir

# Проверяем текущие настройки ACL для каталога
getfacl /project_dir
getfacl /project_dir/*