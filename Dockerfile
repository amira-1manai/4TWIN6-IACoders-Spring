# Use adoptopenjdk base image
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the Jenkins workspace into the container
COPY /var/lib/jenkins/workspace/MohamedMokhtar-Hadded-Foyer-User/target/springboot3-security-0.0.1-SNAPSHOT.jar /app/springboot3-security.jar

# Command to run the application
CMD ["java", "-jar", "springboot3-security.jar"]
