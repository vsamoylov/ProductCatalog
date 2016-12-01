FROM tomcat:8

RUN apt-get update -y
RUN apt-get install -y mysql-client
COPY *.war /usr/local/tomcat/webapps/
ADD run.sh ./
ADD db.sql ./
RUN chmod +x ./run.sh

CMD [./run.sh]
