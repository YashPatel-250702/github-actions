# Declaring base container
FROM openjdk:17-jdk-slim

# Make working directory inside container
WORKDIR /app
# Copying jar file and changing name to app.jar
COPY target/demo-0.1.jar app.jar

# Entry point commands
ENTRYPOINT ["java", "-jar", "app.jar"]
