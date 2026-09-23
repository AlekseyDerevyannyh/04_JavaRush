# Устанавливаем новый пароль для пользователя developer
sudo passwd developer

# Принуждаем пользователя сменить пароль при следующем входе
sudo passwd -e developer

# Проверяем параметры пользователя
sudo chage -l developer