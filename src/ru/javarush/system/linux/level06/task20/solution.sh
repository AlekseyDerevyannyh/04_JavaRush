#!/bin/bash

# 1. Создайте zip-архив из папки project_folder
zip -r project.zip project_folder

# 2. Извлеките содержимое архива в директорию /tmp/project
mkdir -p /tmp/project
unzip project.zip -d /tmp/project
