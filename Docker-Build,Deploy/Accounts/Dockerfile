FROM openjdk:17-jdk-slim

COPY target/Accounts.jar /accounts-dockerfile-img.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/accounts-dockerfile-img.jar"]