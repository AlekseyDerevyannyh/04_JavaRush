# Создаем папку project с вложенными папками src и docs
mkdir -p project/{src,docs}

# Создаем файл readme.txt в папке docs
touch project/docs/readme.txt

# Копируем файл readme.txt из папки docs в папку src
cp project/docs/readme.txt project/src/

# Перемещаем файл readme.txt из папки src в корневую папку project
mv project/src/readme.txt project/