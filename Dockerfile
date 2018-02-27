FROM openjdk:8
ADD build/libs/docker-0.1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]