FROM openjdk:26-ea-17-jdk-slim

COPY target/bank-loans.jar bank-loans.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "bank-loans.jar"]