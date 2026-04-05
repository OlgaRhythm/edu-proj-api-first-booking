# Учебный проект: Бронирование переговорных комнат

## Описание проекта

Сервис для бронирования переговорных комнат. Проект демонстрирует подход API First — сначала разрабатывается 
спецификация OpenAPI, а затем на её основе генерируется код.

### Возможности API

- **Просмотр списка переговорных комнат** — получение списка всех доступных комнат с информацией о вместимости и оснащении
- **Проверка занятости** — просмотр забронированных слотов для конкретной комнаты на выбранную дату
- **Создание бронирования** — запись переговорной комнаты на определённое время для пользователя
- **Управление бронированиями** — просмотр деталей и отмена существующих записей

## Технологии

- **OpenAPI 3.0.3** — спецификация API
- **Java 21** + **Spring Boot 3** — реализация сервиса
- **Maven** — сборка проекта
- **OpenAPI Generator** — генерация кода из спецификации

## Метрики и мониторинг

### Стек мониторинга
- **Prometheus** — сбор и хранение метрик (TSDB)
- **Grafana** — визуализация и дашборды
- **Spring Boot Actuator + Micrometer** — экспорт метрик из приложения

### Доступ к сервисам

| Сервис | URL | Описание |
|--------|-----|----------|
| Приложение | http://localhost:8080 | API сервер |
| Метрики | http://localhost:8080/actuator/prometheus | Prometheus-метрики |
| Prometheus | http://localhost:9090 | UI для запросов к метрикам |
| Grafana | http://localhost:3000 | Дашборды (логин: admin / admin) |

![prometheus_m.png](docs/prometheus_m.png)

### Продуктовые метрики

| Метрика | Тип | Описание |
|---------|-----|----------|
| `bookings_total` | Counter | Общее количество созданных бронирований |
| `bookings_cancelled_total` | Counter | Общее количество отменённых бронирований |
| `booking_duration_seconds` | Histogram | Длительность бронирования (p50, p90, p95) |
| `bookings.room.{id}` | Counter | Количество бронирований по комнатам |

### PromQL запросы на дашборде

| График | PromQL запрос |
|--------|---------------|
| Всего бронирований | `bookings_total` |
| Бронирований в минуту | `rate(bookings_total[1m])` |
| Процент отмен | `(bookings_cancelled_total / bookings_total) * 100` |

![booking_total.png](docs/booking_total.png)
![rate_booking.png](docs/rate_booking.png)
![canceled_booking.png](docs/canceled_booking.png)

В Prometheus
![prometheus.png](docs/prometheus.png)

### Запуск стека мониторинга

1. **Запустить Prometheus** (с конфигом `prometheus.yml`):
```bash
prometheus --config.file=prometheus.yml
```
2. Запустить Grafana:
```bash
brew services start grafana  # macOS
# или
docker run -d -p 3000:3000 grafana/grafana
```
3. Настроить источник данных в Grafana:
- URL: http://localhost:9090
- Тип: Prometheus

## Swagger UI

При запуске проекта доступ по url:
http://localhost:8080/swagger-ui/index.html

![pic_swagger.png](docs/pic_swagger.png)

## Особенность проекта: API First подход

Главная особенность этого проекта — строгое следование методологии **API First**:

1. **Сначала спецификация** — разработка началась с создания файла `meeting_rooms.yaml`, в котором описан контракт API: эндпоинты, модели данных, коды ответов
2. **Генерация кода** — на основе спецификации с помощью OpenAPI Generator создан скелет приложения:
   ```bash
   ./generate.sh
   ```
   Скрипт использует Docker-образ `openapitools/openapi-generator-cli` для генерации Spring Boot проекта
3. **Реализация логики** — в сгенерированную структуру добавляется бизнес-логика, при этом все изменения вносятся только в созданные вручную контроллеры, а сгенерированные интерфейсы и модели остаются нетронутыми

## Запуск проекта

### Предварительные требования
- Java 21 или выше
- Maven
- Docker (только для генерации кода)

### Шаги для запуска

1. **Клонировать репозиторий**
   ```bash
   git clone https://github.com/OlgaRhythm/edu-proj-first-api-booking.git
   cd edu-proj-first-api-booking
   ```

2. **Сгенерировать код (опционально, если не использовать готовый)**
   ```bash
   chmod +x generate.sh
   ./generate.sh
   ```

3. **Перейти в папку с проектом**
   ```bash
   cd spring
   ```

4. **Запустить приложение**
   ```bash
   mvn spring-boot:run
   ```

5. **Открыть в браузере**
    - Swagger UI: http://localhost:8080/swagger-ui.html
