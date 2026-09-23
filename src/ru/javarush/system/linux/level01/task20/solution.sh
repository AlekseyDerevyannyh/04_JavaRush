# Создаем директорию task4 в домашней директории
mkdir ~/task4

# Переходим в созданную директорию
cd ~/task4

# Создаем текстовый файл testfile.txt и добавляем в него текст
touch testfile.txt
echo "Hello, Linux World!" > testfile.txt

# Создаем поддиректорию backup
mkdir backup

# Копируем файл testfile.txt в поддиректорию backup и называем его backup_testfile.txt
cp testfile.txt backup/backup_testfile.txt

# Удаляем файл testfile.txt из текущей директории
rm testfile.txt

# Восстанавливаем файл, копируя из поддиректории backup обратно
cp backup/backup_testfile.txt testfile.txt

# Проверяем содержимое восстановленного файла
cat testfile.txt