# Compilación del proyecto
FROM openjdk:17-bullseye as build
WORKDIR /app
# Copia todo el proyecto al contenedor, asegurándote de incluir el Gradle Wrapper
COPY . .
# Da permisos de ejecución al Gradle Wrapper y ejecuta la construcción
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test --no-daemon --info

# Fase de ejecución del proyecto
FROM openjdk:17
WORKDIR /app
# Copia el JAR desde la etapa de construcción a la etapa de ejecución
COPY --from=build /app/build/libs/*.jar app.jar
# Expone el puerto 8080
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]