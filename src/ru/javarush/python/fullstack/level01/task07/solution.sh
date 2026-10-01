echo "Присутствует ли значек docker в системном трее? (y/n): "
read ANSWER

if [ "$ANSWER" = "y" ]; then
    echo "Docker установлен в Windows или MacOS"
else
    echo "Docker не установлен в Windows или MacOS"
fi

# Скрипт для проверки статуса Docker Daemon на Linux
systemctl status docker
