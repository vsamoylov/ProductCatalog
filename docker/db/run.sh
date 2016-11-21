#!/bin/bash

mysqld&
sleep 15

mysql -u root -p root < db.sql >> /var/log/mysql.log

tail -f /var/log/mysql.log
