# ---- Stage 1: Builder ----
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Копируем только pom.xml файлы для кэширования зависимостей
COPY pom.xml .
COPY common/pom.xml common/pom.xml
COPY esp/pom.xml esp/pom.xml
COPY integration/pom.xml integration/pom.xml
COPY ubk/pom.xml ubk/pom.xml

# Качаем зависимости (кэшируется)
RUN mvn dependency:go-offline -B

# Копируем исходники
COPY . .

# Собираем Common модуль + его зависимости
RUN mvn clean package -pl common -am -DskipTests

# ---- Stage 2: Runtime ----
FROM eclipse-temurin:21-jre AS runtime

WORKDIR /app

# Копируем JAR из builder
COPY --from=builder /app/common/target/*.jar app.jar

# Создаем пользователя и назначаем владельца
RUN addgroup --system spring && adduser --system spring --ingroup spring && \
    chown spring:spring app.jar

USER spring:spring

EXPOSE 8084

# Переменные окружения
ENV COMMON_SERVER_PORT=8084 \
    COMMON_DB_URL=jdbc:postgresql://localhost:5432/common_db \
    COMMON_DB_USER=common_user \
    COMMON_DB_PASS=common_password

ENTRYPOINT ["java", "-jar", "app.jar"]
