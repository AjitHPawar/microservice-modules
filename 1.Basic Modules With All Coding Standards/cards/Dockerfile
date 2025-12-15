FROM openjdk:26-ea-17-jdk-slim

COPY target/bank-cards.jar bank-cards.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "bank-cards.jar"]