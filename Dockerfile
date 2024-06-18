FROM openjdk:17-jdk

COPY target/sistema-biomedicina-0.0.1-SNAPSHOT.jar /app/biomed.jar

CMD ["java", "-jar", "/app/biomed.jar"]