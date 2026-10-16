# Сборка Docker-образа
docker build -t myapp .

# Запуск Docker-контейнера
docker run -d --name myapp_container myapp

# Мониторинг операций ввода/вывода
docker inspect myapp_container
docker stats
