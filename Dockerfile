FROM alpine
RUN apk add --no-cache openjdk17
EXPOSE 80
ADD target/4TWIN6-AICoders-Foyer.jar 4TWIN6-AICoders-Foyer.jar
CMD ["java", "-jar", "/4TWIN6-AICoders-Foyer.jar"]
