FROM openjdk:26-ea-17-jdk-slim

COPY target/bank-accounts.jar bank-accounts.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "bank-accounts.jar"]
