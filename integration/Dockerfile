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
RUN mvn clean package -pl integration -am -DskipTests

# Создаем пользователя для безопасности
RUN addgroup --system spring && adduser --system spring --ingroup spring

# Копируем JAR файл
RUN cp integration/target/*.jar app.jar

# Меняем владельца файлов
RUN chown spring:spring app.jar

# Переключаемся на пользователя spring
USER spring:spring

# Открываем порт
EXPOSE 8082

# Устанавливаем переменные окружения по умолчанию
ENV INTEGRATION_SERVER_PORT=8082
ENV INTEGRATION_DB_URL=jdbc:postgresql://localhost:5432/integration_db
ENV INTEGRATION_DB_USER=integration_user
ENV INTEGRATION_DB_PASS=integration_password
ENV INTEGRATION_API_BASE_URL=http://localhost:8082
ENV INTEGRATION_API_X_API_KEY=your-api-key
ENV INTEGRATION_API_USER_NAME=integration_user
ENV INTEGRATION_API_ROLE_NAME=integration_role

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
