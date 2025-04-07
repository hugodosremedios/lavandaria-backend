# Etapa de build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copia todos os arquivos para dentro do container
COPY . .

# Compila o projeto e cria o .jar (sem testes)
RUN mvn clean package -DskipTests

# Etapa final - imagem mais leve
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o .jar da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que a aplicação vai escutar
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

