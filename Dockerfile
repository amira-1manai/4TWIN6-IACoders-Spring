FROM alpine
RUN apk add --no-cache openjdk17
EXPOSE 80
CMD ["java", "-version"]
