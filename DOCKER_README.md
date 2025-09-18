# Docker Setup для проекта ESSO

Этот документ описывает настройку и использование Docker для модулей проекта ESSO.

## Структура проекта

Проект состоит из 4 модулей:
- **common** - общий модуль (порт 8080)
- **esp** - ежемесячное социальное пособие (порт 8081)
- **integration** - модуль интеграции (порт 8082)
- **ubk** - помощь семьям (порт 8083)

## Настройка окружения

### 1. Создание .env файла

Скопируйте файл `env.example` в `.env` и настройте переменные:

```bash
cp env.example .env
```

### 2. Настройка баз данных

В файле `.env` укажите параметры подключения к вашим базам данных:

```bash
# Пример для локальных БД
COMMON_DB_URL=jdbc:postgresql://localhost:5432/common_db
ESP_DB_URL=jdbc:postgresql://localhost:5432/esp_db
INTEGRATION_DB_URL=jdbc:postgresql://localhost:5432/integration_db
UBK_DB_URL=jdbc:postgresql://localhost:5432/ubk_db

# Пример для внешнего сервера БД
COMMON_DB_URL=jdbc:postgresql://your-db-server:5432/common_db
ESP_DB_URL=jdbc:postgresql://your-db-server:5432/esp_db
INTEGRATION_DB_URL=jdbc:postgresql://your-db-server:5432/integration_db
UBK_DB_URL=jdbc:postgresql://your-db-server:5432/ubk_db
```

## Быстрый старт

### 1. Запуск всех модулей

```bash
# Запуск всех сервисов
docker-compose up -d

# Просмотр логов
docker-compose logs -f

# Остановка всех сервисов
docker-compose down
```

### 2. Запуск отдельных модулей

```bash
# Запуск только модуля common
cd common
docker-compose up -d

# Запуск только модуля esp
cd esp
docker-compose up -d

# Запуск только модуля integration
cd integration
docker-compose up -d

# Запуск только модуля ubk
cd ubk
docker-compose up -d
```

## Порты и доступ

| Модуль | Порт приложения | URL |
|--------|----------------|-----|
| Common | 8080 | http://localhost:8080/api/common |
| ESP | 8081 | http://localhost:8081/api/esp |
| Integration | 8082 | http://localhost:8082/api/integration |
| UBK | 8083 | http://localhost:8083/api/ubk |

## Базы данных

Каждый модуль подключается к внешней базе данных PostgreSQL. Убедитесь, что базы данных созданы и доступны:

- **common_db** - база данных для модуля common
- **esp_db** - база данных для модуля esp
- **integration_db** - база данных для модуля integration
- **ubk_db** - база данных для модуля ubk

## Переменные окружения

Основные переменные в файле `.env`:

### Порты приложений
- `COMMON_SERVER_PORT` - внутренний порт для модуля common
- `ESP_SERVER_PORT` - внутренний порт для модуля esp
- `INTEGRATION_SERVER_PORT` - внутренний порт для модуля integration
- `UBK_SERVER_PORT` - внутренний порт для модуля ubk

### Порты для внешнего доступа
- `COMMON_PORT` - внешний порт для модуля common
- `ESP_PORT` - внешний порт для модуля esp
- `INTEGRATION_PORT` - внешний порт для модуля integration
- `UBK_PORT` - внешний порт для модуля ubk

### Настройки баз данных
- `*_DB_URL` - URL базы данных для каждого модуля
- `*_DB_USER` - пользователь базы данных
- `*_DB_PASS` - пароль базы данных

### Настройки Integration API
- `INTEGRATION_API_BASE_URL` - базовый URL для API интеграции
- `INTEGRATION_API_X_API_KEY` - API ключ
- `INTEGRATION_API_USER_NAME` - имя пользователя
- `INTEGRATION_API_ROLE_NAME` - роль пользователя

## Полезные команды

### Управление контейнерами

```bash
# Просмотр запущенных контейнеров
docker-compose ps

# Перезапуск конкретного сервиса
docker-compose restart common-app

# Просмотр логов конкретного сервиса
docker-compose logs -f common-app

# Выполнение команд в контейнере
docker-compose exec common-app bash
```

### Управление базами данных

Поскольку базы данных теперь внешние, используйте стандартные команды PostgreSQL:

```bash
# Подключение к базе данных common
psql -h localhost -p 5432 -U common_user -d common_db

# Подключение к базе данных esp
psql -h localhost -p 5432 -U esp_user -d esp_db

# Подключение к базе данных integration
psql -h localhost -p 5432 -U integration_user -d integration_db

# Подключение к базе данных ubk
psql -h localhost -p 5432 -U ubk_user -d ubk_db
```

### Очистка

```bash
# Остановка и удаление контейнеров
docker-compose down

# Остановка и удаление контейнеров с volumes
docker-compose down -v

# Удаление образов
docker-compose down --rmi all

# Полная очистка (контейнеры, volumes, образы)
docker-compose down -v --rmi all
```

## Разработка

### Пересборка образов

```bash
# Пересборка всех образов
docker-compose build

# Пересборка конкретного сервиса
docker-compose build common-app

# Пересборка и запуск
docker-compose up --build
```

### Отладка

```bash
# Запуск в режиме отладки с выводом логов
docker-compose up

# Просмотр логов в реальном времени
docker-compose logs -f

# Проверка состояния сервисов
docker-compose ps
```

## Мониторинг

### Health checks

Все сервисы имеют health checks. Проверить статус можно через:

```bash
# Проверка здоровья всех сервисов
docker-compose ps

# Проверка конкретного сервиса
curl http://localhost:8080/actuator/health
curl http://localhost:8081/actuator/health
curl http://localhost:8082/actuator/health
curl http://localhost:8083/actuator/health
```

## Troubleshooting

### Проблемы с портами

Если порты заняты, измените их в файле `docker-compose.yml` или `.env`.

### Проблемы с базами данных

```bash
# Проверка подключения к БД
pg_isready -h localhost -p 5432 -U common_user

# Проверка доступности БД из контейнера
docker-compose exec common-app ping your-db-server

# Проверка сетевого подключения
docker-compose exec common-app telnet your-db-server 5432
```

### Проблемы с памятью

```bash
# Очистка неиспользуемых ресурсов
docker system prune -a

# Очистка volumes
docker volume prune
```

## Безопасность

- Все пароли в примерах являются демонстрационными
- В продакшене используйте сильные пароли
- Настройте firewall для ограничения доступа к портам БД
- Используйте secrets для хранения чувствительных данных
