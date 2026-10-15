# Остановите и удалите сервис Nginx, который использует конфигурацию
docker service rm nginx

# Остановите и удалите сервис PostgreSQL, который использует секрет
docker service rm postgres

# Удалите конфигурацию Nginx (например, nginx_config_v1 и nginx_config_v2)
docker config rm nginx_config_v1 nginx_config_v2

# Удалите секрет базы данных PostgreSQL (например, postgres_password)
docker secret rm postgres_password

# Проверьте, что конфигурации и секреты удалены
docker config ls
docker secret ls
