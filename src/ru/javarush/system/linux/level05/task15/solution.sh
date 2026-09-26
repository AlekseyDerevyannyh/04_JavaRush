#!/bin/bash

# Создание каталога acl_test_dir
mkdir acl_test_dir

# Установка прав ACL по умолчанию, чтобы пользователь user1 получал права rw на новые файлы
sudo setfacl -d -m u:user1:rw acl_test_dir

# Создание нового файла test_file.txt внутри каталог
touch acl_test_dir/test_file.txt

# Вывод текущих прав ACL нового файла для проверки
getfacl acl_test_dir/test_file.txt
