FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/register-0.0.1-SNAPSHOT.jar register.jar
ENTRYPOINT ["java","-jar","/register.jar"]