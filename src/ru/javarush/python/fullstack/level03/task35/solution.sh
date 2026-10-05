# Построение обновленного образа
docker build -t yourusername/mynodeapp:2.0 .

# Аутентификация в Docker Hub (это потребует ввода учетных данных)
docker login

# Публикация образа в Docker Hub
docker push yourusername/mynodeapp:2.0
