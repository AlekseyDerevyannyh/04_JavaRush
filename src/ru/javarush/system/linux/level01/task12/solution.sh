# Создание структуры директорий
mkdir -p website/assets/css website/assets/js website/content

# Создание файлов
touch website/index.html website/assets/css/styles.css website/assets/js/script.js

# Копирование папки assets в content
cp -r website/assets website/content

# Удаление папки js из assets
rm -r website/assets/js