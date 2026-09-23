# Измените имя пользователя `new_user` на `developer`.
sudo usermod -l developer new_user

# Смените домашнюю директорию пользователя на `/home/developer` с переносом всех данных.
sudo usermod -d /home/developer -m developer

# Визуально проверьте изменения в файле `/etc/passwd`.
grep developer /etc/passwd