# Hikerz Activity Microservice

A Spring Boot microservice for managing hiking activities, GPX imports, and geographic data visualization.

## Features

- Create and manage hiking activities
- Import GPX files with route data
- Generate GeoJSON for route visualization
- Create static map images using Mapbox API
- Query activities by user and friends
- Spatial data support with PostGIS

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL with PostGIS extension
- Docker (optional, for containerized setup)

## Running the Application

### Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Using packaged JAR

```bash
./mvnw clean package
java -jar target/hikerzactivity-0.0.1-SNAPSHOT.jar
```

### With Docker Compose

```bash
cd ../../infra/docker
docker-compose up -d
```

## API Endpoints

### Activities

- `POST /api/activity` - Create a new activity
- `GET /api/activity` - Get all activities
- `GET /api/activity/user/{username}` - Get activities by user
- `GET /api/activity/{username}/friends-activities` - Get friends' activities
- `GET /api/activity/{id}/geojson` - Get activity route as GeoJSON
- `GET /api/activity/{id}/mapbox-static` - Get static map image (PNG)
- `POST /api/activity/upload-gpx` - Import GPX file


### Running Tests

#### Run all tests

```bash
./mvnw test
```

#### Run specific test class

```bash
./mvnw test -Dtest=ActivityServiceTest
```

#### Run specific test method

```bash
./mvnw test -Dtest=ActivityServiceTest#testCreateActivity
```

#### Run tests with coverage report

```bash
./mvnw clean test jacoco:report
```

After running with coverage, open the report at:
```
target/site/jacoco/index.html
```

```

### Coverage Reports

The project uses **JaCoCo** for code coverage analysis.

#### Generate coverage report

```bash
./mvnw clean test jacoco:report
```

#### View coverage report

Open `target/site/jacoco/index.html` in your browser.