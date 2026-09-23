# 1. Создание директории task3 в домашней директории
mkdir ~/task3

# 2. Переход в созданную директорию
cd ~/task3

# 3. Создание текстового файла testfile.txt с текстом "Hello, Linux World!"
echo "Hello, Linux World!" > testfile.txt

# 4. Создание поддиректории backup внутри task3
mkdir backup

# 5. Копирование файла testfile.txt в поддиректорию backup с новым именем backup_testfile.txt
cp testfile.txt backup/backup_testfile.txt

# 6. Проверка наличия файла testfile.txt в текущей директории
ls

# 7. Проверка наличия файла backup_testfile.txt в поддиректории backup
ls backup