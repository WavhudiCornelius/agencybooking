# Use the appropriate base image for OpenJDK 17
FROM azul/zulu-openjdk-alpine:17

# The rest of your Dockerfile remains the same...
WORKDIR /app
COPY /target/agencyBooking-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
