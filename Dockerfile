FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/devops-java-app-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-cp", "app.jar", "com.devops.App"]