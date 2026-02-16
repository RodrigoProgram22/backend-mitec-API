# Paso 1: Compilación (Build)
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Paso 2: Ejecución (Runtime)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copiamos el archivo JAR usando el finalName que pusimos en el pom.xml
COPY --from=build /app/target/tienda-backend.jar app.jar

EXPOSE 8080

# Configuración de memoria optimizada para el plan gratuito de Render
ENTRYPOINT ["java", "-Xmx512m", "-Xms256m", "-XX:+UseSerialGC", "-jar", "app.jar"]