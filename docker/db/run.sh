#!/bin/bash

mysqld > /dev/null 2>&1 &

sleep 15

mysql -u root -p root < db.sql >> /var/log/mysql.log

tail -f /var/log/mysql.log
