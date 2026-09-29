#!/bin/bash

# Запрос нового сертификата для домена example.com и поддомена www.example.com с использованием Nginx
sudo certbot --non-interactive --nginx -d example.com -d www.example.com
