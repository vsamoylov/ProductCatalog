#!/bin/bash

mysqld >> /var/log/mysql.log 2&>1 &
sleep 15

mysql -u root -p root < db.sql

tail -f /var/log/mysql.log
