# Используем образ Ubuntu
FROM ubuntu

# Обновляем пакетный индекс, устанавливаем Git и curl, затем удаляем кэш пакетов
RUN apt update && apt install git curl && apt clean

# Устанавливаем рабочую директорию
WORKDIR /app

# Команда по умолчанию
CMD ["bash"]