FROM tomcat:10.1.5-jre11
WORKDIR /usr/local/tomcat/webapps/
COPY target/cloudbots_warproj.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
