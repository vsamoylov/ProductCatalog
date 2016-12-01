#!/bin/bash

sleep 15

mysql -h db -u root -p root < db.sql >> /var/log/mysql.log

catalina.sh run
