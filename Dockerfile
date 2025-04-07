# Etapa de build
FROM maven:3.8.5-openjdk-17-slim AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o conteúdo do projeto para dentro do container
COPY . .

# Entra na subpasta onde está o projeto Maven
WORKDIR /app/lavandaria

# Compila o projeto e gera o JAR (sem rodar testes)
RUN mvn clean package -DskipTests

# Etapa final - imagem leve com apenas o JAR
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho final
WORKDIR /app

# Copia o JAR gerado para essa imagem final
COPY --from=build /app/lavandaria/target/*.jar app.jar

# Expõe a porta usada pela aplicação
EXPOSE 8080

# Comando para rodar o app
CMD ["java", "-jar", "app.jar"]



