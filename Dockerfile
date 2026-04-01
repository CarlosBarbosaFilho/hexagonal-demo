# Estágio de Build: Usando imagem com Maven 3.9 + Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# 1. Copia apenas o pom.xml para baixar as dependências (cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# 2. Copia o código fonte e gera o .jar
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio de Execução (JRE leve)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]