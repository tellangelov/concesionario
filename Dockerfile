FROM eclipse-temurin:21-jre

ENV JAR_FILE=concesionario-0.0.1-SNAPSHOT.jar
WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar /app/${JAR_FILE}"]
