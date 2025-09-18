# Используем официальный образ OpenJDK 21
FROM openjdk:21-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем pom.xml для кэширования зависимостей
COPY pom.xml .

# Копируем все модули (нужно для Maven multi-module проекта)
COPY common ./common
COPY esp ./esp
COPY integration ./integration
COPY ubk ./ubk

# Устанавливаем Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Собираем приложение
RUN mvn clean package -pl common -am -DskipTests

# Создаем пользователя для безопасности
RUN addgroup --system spring && adduser --system spring --ingroup spring

# Копируем JAR файл (Spring Boot создает исполняемый JAR)
RUN cp common/target/*.jar app.jar

# Меняем владельца файлов
RUN chown spring:spring app.jar

# Переключаемся на пользователя spring
USER spring:spring

# Открываем порт
EXPOSE 8084

# Устанавливаем переменные окружения по умолчанию
ENV COMMON_SERVER_PORT=8084
ENV COMMON_DB_URL=jdbc:postgresql://localhost:5432/common_db
ENV COMMON_DB_USER=common_user
ENV COMMON_DB_PASS=common_password

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
