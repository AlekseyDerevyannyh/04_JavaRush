# Сборка Docker-образа с вашим именем пользователя Docker Hub:
docker build -t myapp:latest .
docker tag myapp:latest derevyannyhaa/myapp:latest

# Авторизация в Docker Hub:
docker login

# Публикация образа в Docker Hub:
docker push derevyannyhaa/myapp:latest
