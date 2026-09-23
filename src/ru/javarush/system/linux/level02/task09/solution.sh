# Создаем новую группу с именем team_alpha с использованием команды groupadd
sudo groupadd team_alpha

# Проверяем, что группа была добавлена успешно. Для этого выводим информацию о группах и ищем "team_alpha".
getent group | grep team_alpha