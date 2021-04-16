FROM adoptopenjdk/openjdk11:latest
COPY target/api-login.jar api-login.jar
CMD java -jar api-login.jar
EXPOSE 8090