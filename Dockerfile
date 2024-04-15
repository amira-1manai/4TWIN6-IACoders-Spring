


FROM openjdk:17-alpine
WORKDIR /app
COPY 4TWIN6-AICoders-Foyer.jar /app/
RUN apk --no-cache add curl
EXPOSE 8181
ENTRYPOINT [ "java", "-jar", "4TWIN6-AICoders-Foyer.jar" ]
