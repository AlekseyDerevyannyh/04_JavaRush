#!/bin/bash

# Переводим SELinux в permissive-режим
sudo setenforce 0

# Проверяем, что SELinux находится в permissive-режиме
getenforce

# Переводим SELinux обратно в enforcing-режим
sudo setenforce 1

# Проверяем, что SELinux находится в enforcing-режиме
getenforce