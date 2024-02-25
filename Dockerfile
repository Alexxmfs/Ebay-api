FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN mvn clean install

CMD ["java", "-jar", "cardapio-0.0.1-SNAPSHOT.war"]