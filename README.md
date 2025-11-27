README — Central Monitoring Service
🛡️ Central Monitoring Service

Alarm Evaluator → Sensor Threshold Monitor

The Central Monitoring Service consumes sensor measurement events from the message broker (Kafka) and evaluates whether measurements from any warehouse exceed configured thresholds. When an alarm is detected, the service logs a warning and persists the alarm.

🔧 Features

Consumes events from Kafka

Evaluates thresholds:

Temperature > 35°C

Humidity > 50%

Logs alarm events in console

Persists alarm results to DB

Exposes REST endpoint to list alarms:

GET /v1/api/alarms


Pagination support

Optional filtering by sensorType

🗂️ Project Structure
central-service/
 ├── kafka/            # Kafka consumer
 ├── domain/           # Alarm entity
 ├── dto/              # Alarm response DTO
 ├── mapper/           # Entity <→ DTO mapping
 ├── controller/       # REST endpoint
 ├── repository/       # JPA repository
 ├── service/          # Alarm business logic
 ├── config/           # Security, Kafka, DB
 └── test/             # Unit tests

⚙️ Alarm Logic

Example output:

🚨 ALARM ACTIVATED! TEMPERATURE reading exceeded threshold: t1 -> 38°C > 35°C


If below threshold:

STATUS OK: HUMIDITY reading is within limits.

📡 Kafka Input Format

Events expected:

{
  "sensorId": "t1",
  "type": "TEMPERATURE",
  "value": 38.0
}

🌐 REST API
Get alarms
GET /v1/api/alarms?page=0&size=20&sensorType=temperature

Response example:
{
  "content": [
    {
      "id": 1,
      "sensorId": "t1",
      "sensorType": "temperature",
      "value": 38.0,
      "threshold": 35.0,
      "message": "Exceeded temperature limit",
      "createdAt": "2025-11-27T12:00:12Z"
    }
  ]
}


All endpoints under /v1/api/alarms are public.

🛠️ How to Run
1. Start dependencies:
docker compose up -d

2. Start service:
./mvnw spring-boot:run

🧪 Tests
./mvnw test


Includes tests for:

Kafka listener

Alarm evaluation logic

Controller pagination & filtering

Mapper logic

🔥 Responsibilities

The Central Monitoring Service:

Receives events from warehouses

Evaluates configured thresholds

Logs alarms to console

Stores alarms in database

Exposes REST API for alarm listing
