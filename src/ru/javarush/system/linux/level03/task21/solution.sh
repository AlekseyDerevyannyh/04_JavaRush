# Добавление задачи в crontab для записи текущей даты и времени в файл ~/task1.log каждые 2 минуты
echo '*/2 * * * * echo "$(date)" > ~/task1.log' | crontab -