#!/bin/bash

# Создаем файл testfile.txt, если он не существует
[ -f testfile.txt ] || touch testfile.txt

# Устанавливаем ACL права по умолчанию (необязательно, если файл создан только что)
sudo sefacl -b testfile.txt

# Выводим текущие ACL права файла testfile.txt
getfacl testfile.txt