FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY /var/lib/jenkins/workspace/MohamedMokhtar-Hadded-Foyer-User/target/springboot3-security-0.0.1-SNAPSHOT.jar /app/springboot3-security.jar
CMD ["java", "-jar", "/opt/app/springboot3-security.jar"]
