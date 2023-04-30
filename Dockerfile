FROM tomcat:10-jdk11-openjdk-slim
WORKDIR /usr/local/tomcat/webapps/
COPY target/cloudbots_warproj.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
