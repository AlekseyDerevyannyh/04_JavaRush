# Указание базового изображения для Python
FROM python:3.9-slim

# Установка рабочей директории
WORKDIR /app

# Копирование файла run.py в контейнер
COPY run.py /app/

# Установка необходимых пакетов для Flask
RUN pip install --no-cache-dir flask

# Настройка порта для работы приложения
EXPOSE 5000

# Указание команды для запуска Flask-приложения
CMD ["python", "run.py"]
