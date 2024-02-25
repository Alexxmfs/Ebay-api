# Stage 1: Build the Spring Boot application
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /produto-api-

# Copiando o arquivo pom.xml primeiro para aproveitar o cache do Docker
COPY pom.xml .
# Em seguida, copie todo o código-fonte e compile o projeto
COPY src ./src
RUN mvn clean install

# Stage 2: Run the application with OpenJDK
FROM openjdk:17-jdk-slim

WORKDIR /produto-api-

EXPOSE 8080

# Copiando o conteúdo da pasta target (onde o Maven gera os artefatos) na etapa anterior
COPY --from=build /produto-api-/target/ .

ENTRYPOINT ["java", "-jar", "app.jar"]