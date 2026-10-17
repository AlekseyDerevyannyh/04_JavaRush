# Создание React-приложения:
npx create-react-app my-react-app

# Сборка образа по Dockerfile, который берёт файлы проекта из my-react-app
docker build -t react-app-image .

# Запуск React-приложения в контейнере, порт 3000 проброшен на хост
docker run -d --name react-app -p 3000:3000 react-app-image
