(crontab -l 2>/dev/null; echo "0 2 * * * sh -c '
BACKUP_DIR=\"/path/to/backup_directory\"
VOLUME_NAME=\"app_data\"
mkdir -p \$BACKUP_DIR
BACKUP_FILE=\"\$BACKUP_DIR/\${VOLUME_NAME}_backup_\$(date +\%Y\%m\%d_\%H\%M).tar.gz\"
docker run --rm -v \$VOLUME_NAME:/data -v \$BACKUP_DIR:/backup busybox tar czf /backup/\$(basename \"\$BACKUP_FILE\") -C /data .
find \$BACKUP_DIR -type f -name \"\${VOLUME_NAME}_backup_*.tar.gz\" -mtime +7 -exec rm -f {} \;
'") | crontab -