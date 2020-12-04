FROM tomcat:latest
ADD target/my-simple-calculator.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]