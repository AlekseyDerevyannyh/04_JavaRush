#!/bin/bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install certbot python3-certbot-nginx
sudo apt-get install certbot python3-certbot-apache

# Для Nginx: получение SSL-сертификата
sudo certbot --nginx -d mysite.com

# Для Apache: получение SSL-сертификата
sudo certbot --apache -d mysite.com

# Убедитесь, что сертификат был успешно установлен
sudo certbot certificates

# Протестируйте автоматическое обновление сертификатов
sudo certbot renew --dry-run
curl -I https://mysite.com