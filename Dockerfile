FROM openjdk:17

# Create the directory and copy the class file
WORKDIR /app/myapp
COPY "build/libs/logManagementMock-1.0-SNAPSHOT.jar" /app/myapp/logManagementMock-1.0-SNAPSHOT.jar

# Set the entry point
ENTRYPOINT ["java", "-jar", "/app/myapp/logManagementMock-1.0-SNAPSHOT.jar"]