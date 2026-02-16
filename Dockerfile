# ETAPA 1: Compilación (Build)
# Usamos Maven para construir el proyecto
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
# Ejecutamos el empaquetado saltando los tests para ahorrar RAM y tiempo
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Runtime)
# Usamos una imagen de Java muy ligera
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiamos el archivo .jar generado en la etapa anterior
# IMPORTANTE: "tienda-backend.jar" debe coincidir con el <finalName> de tu pom.xml
COPY --from=build /app/target/tienda-backend.jar app.jar

# Exponemos el puerto estándar
EXPOSE 8080

# Comando de inicio optimizado para Railway (plan gratuito)
# -Xmx350m: Limita la memoria RAM al máximo para que Railway no mate el proceso
# -XX:+UseSerialGC: Optimiza el uso de CPU y RAM en contenedores pequeños
ENTRYPOINT ["java", "-Xmx350m", "-Xms256m", "-XX:+UseSerialGC", "-jar", "app.jar"]