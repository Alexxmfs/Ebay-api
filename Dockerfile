FROM openjdk:17-jdk-slim

# Install Maven (optional, check if already included in base image)
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy pom.xml to the container
COPY pom.xml .

# Build the WAR file (adjust command if necessary)
RUN mvn clean install

# Copy the WAR file to the container
COPY target/cardapio-0.0.1-SNAPSHOT.war .

# Start the API (adjust command if necessary)
CMD ["java", "-jar", "cardapio-0.0.1-SNAPSHOT.war"]
