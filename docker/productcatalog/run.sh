#!/bin/bash

sleep 15

mysql -h db --password=root < db.sql >> /var/log/mysql.log

catalina.sh run
