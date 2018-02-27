FROM openjdk:8
ADD build/libs/testapi.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]