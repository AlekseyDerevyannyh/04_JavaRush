# Обновление списка пакетов
sudo apt-get update

# Установка необходимых пакетов
sudo apt-get install \
    ca-certificates \
    curl \
    gnupg \
    lsb-release

# Добавление GPG ключа Docker
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

# Добавление Docker репозитория
echo \
    "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] \
    https://download.docker.com/linux/ubuntu \
    $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

# Обновление списка пакетов после добавления репозитория Docker
sudo apt-get update

# Установка Docker Engine
sudo apt-get install docker-ce docker-ce-cli containerd.io

# Запуск Docker и настройка его для автозапуска
sudo systemctl enable docker --now

# Проверка версии Docker
sudo usermod -aG docker $USER
sudo chmod 666 /var/run/docker.sock
sudo docker --version
