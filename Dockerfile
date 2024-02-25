FROM openjdk:11-jdk-slim

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .

RUN mvn clean install

COPY target/cardapio-0.0.1-SNAPSHOT.war .

CMD ["java", "-jar", "cardapio-0.0.1-SNAPSHOT.war"]
