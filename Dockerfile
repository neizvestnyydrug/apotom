# Используем официальный образ Java 17
FROM eclipse-temurin:17-jdk-jammy

# Создаем рабочую директорию
WORKDIR /app

# Копируем исходный код в контейнер
COPY . .

# Даем права на выполнение скрипта Gradle
RUN chmod +x gradlew

# Собираем приложение
RUN ./gradlew build

# Открываем порт
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "build/libs/apotom-0.0.1-SNAPSHOT.jar"]