#!/bin/bash

# Подсчёт суммы второго столбца с помощью awk
awk '{sum += $2} END {print sum}' data.txt