# Etapa de construcción
FROM maven:3.9.9-jdk-17 AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests

# Etapa de ejecución
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]