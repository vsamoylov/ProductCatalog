#!/bin/bash

nohup mysqld &>/dev/null &

sleep 15

mysql -u root -p root < db.sql >> /var/log/mysql.log

tail -f /var/log/mysql.log
