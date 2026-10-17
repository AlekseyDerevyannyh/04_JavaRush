# Добавление репозитория Logstash:
wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch | sudo gpg --dearmor -o /usr/share/keyrings/elastic-keyring.gpg
sudo apt-get install apt-transport-https
echo "deb [signed-by=/usr/share/keyrings/elastic-keyring.gpg] https://artifacts.elastic.co/packages/9.x/apt stable main" | sudo tee -a /etc/apt/sources.list.d/elastic-9.x.list

# Обновление списка пакетов:
sudo apt-get update

# Установка Logstash:
sudo apt-get install logstash

# Запуск службы:
sudo systemctl start logstash

# Настройка автозапуска:
sudo systemctl enable logstash
