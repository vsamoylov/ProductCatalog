FROM tomcat:8

RUN apt-get install -y mysql-client-5.5
COPY *.war /usr/local/tomcat/webapps/
ADD run.sh ./
ADD db.sql ./
RUN chmod +x ./run.sh

CMD [./run.sh]
