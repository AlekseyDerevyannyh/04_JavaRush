# Сборка Docker-образа:
docker build -t myapp .

# Запуск контейнера:
docker run -d -p 80:80 myapp
