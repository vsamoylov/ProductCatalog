FROM mysql:5

ENV MYSQL_ROOT_PASSWORD root
ADD ./run.sh
ADD ./db.sql
RUN chmod +x ./run.sh


CMD ["./run.sh"]
