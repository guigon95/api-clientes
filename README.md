# Api Clientes

## Description

This project is a REST API built with Kotlin and Spring Boot. The API provides functionalities to manage client information. It is designed to be scalable, efficient, and easy to maintain, following best practices of clean architecture, clean code principles, and modern development standards.

## Index

- ![About](https://img.icons8.com/fluency/15/000000/info.png) [About](#about)
- ![Technologies](https://img.icons8.com/fluency/15/000000/gear.png) [Technologies](#technologies)
- ![Getting Started](https://img.icons8.com/fluency/15/000000/play.png) [Getting Started](#getting-started)
- ![Project Structure](https://img.icons8.com/fluency/15/000000/domain.png) [Project Structure](#project-structure)
- ![Tests](https://img.icons8.com/fluency/15/000000/checklist.png) [Tests](#tests)
- ![Usage Example](https://img.icons8.com/fluency/15/000000/code.png) [Usage Example](#usage-example)
- ![API Documentation](https://img.icons8.com/fluency/15/000000/book.png) [API Documentation](#api-documentation)
- ![License](https://img.icons8.com/fluency/15/000000/law.png) [License](#license)

## ![About](https://img.icons8.com/fluency/19/000000/info.png) About

This project is a REST API built with Kotlin and Spring Boot. The API provides functionalities to manage client information. It is designed to be scalable, efficient, and easy to maintain, following best practices of clean architecture, clean code principles, and modern development standards.

## ![Technologies](https://img.icons8.com/fluency/19/000000/gear.png) Technologies

- **Kotlin**: Modern programming language that runs on the JVM, supporting reactive and asynchronous programming with coroutines, suspend functions, etc.
- **Spring Boot**: Framework for building Java or Kotlin applications based on microservices.
- **Spring WebFlux**: For reactive applications.
- **Kafka Reactive**: For reactive stream processing.
- **JUnit 5**: Framework for unit testing.
- **Docker**: For containerizing the application.
- **Swagger**: For API documentation.
- **Slf4j**: For logging.

## ![Getting Started](https://img.icons8.com/fluency/19/000000/play.png) Getting Started

### Prerequisites

#### Make sure you have the following tools installed on your machine:

- **Java 21 or higher**
- **Kotlin**
- **Maven**
- **Docker** (if you are using containerization)

### Installing

1. Clone the repository:
    ```sh
    https://github.com/guigon95/api-clientes.git
    cd api-clientes
    ```

2. Install dependencies:
    ```sh
    mvn clean install
    ```

### Running the Application

To run the application, use the following command:
```sh
mvn spring-boot:run
```

The server will start on http://localhost:8080.

### Running the Application with Docker

To run the application in a Docker container, follow these steps:

1. **Build the Docker image:**

   ```sh
   docker build -t api-clientes .
   ```

2. **Run the Docker container:**

   ```sh
   docker run -p 8080:8080 api-clientes
   ```

This will build the Docker image and run the container, exposing the application on port 8080. You can access the application at `http://localhost:8080`.

### Running the Application with Docker Compose

To run the application using Docker Compose, follow these steps:

1. **Create a `docker-compose.yml` file:**

   ```yaml
   version: '3.8'
   services:
     api-clientes:
       build: .
       ports:
         - "8080:8080"
       depends_on:
         - kafka
     kafka:
       image: wurstmeister/kafka:latest
       ports:
         - "9092:9092"
       environment:
         KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092
         KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
     zookeeper:
       image: wurstmeister/zookeeper:latest
       ports:
         - "2181:2181"
   ```

2. **Run Docker Compose:**

   ```sh
   docker-compose up
   ```

This will start the application along with Kafka and Zookeeper services.

## ![Project Structure](https://img.icons8.com/fluency/19/000000/domain.png) Project Structure

The project structure follows the principles of Clean Architecture and is organized as follows:

```
src/
├── main/
│   ├── kotlin/
│   │   ├── com/
│   │   │   ├── guigon.api_clientes/
│   │   │   │   ├── application/        # Use cases and ports
│   │   │   │   ├── domain/             # Domain logic (entities, rules)
│   │   │   │   ├── infrastructure/     # Implementation of external interactions (e.g., database, APIs)
│   │   │   │   ├── interfaceadapters/  # Controllers, adapters, etc.
│   └── resources/
│       ├── application.properties      # Spring Boot configurations
│       ├── logback.xml                 # Log configuration (if needed)
├── test/
│   ├── kotlin/
│   │   ├── com/
│   │   │   ├── guigon.api_clientes/
│   │   │   │   ├── application/        # Use case tests
│   │   │   │   ├── domain/             # Business rule tests
│   │   │   │   ├── infrastructure/     # External interaction tests
│   │   │   │   ├── interfaceadapters/  # Controller and adapter tests
```

## ![Tests](https://img.icons8.com/fluency/19/000000/checklist.png) Tests

### Unit Tests
The project uses JUnit 5 for unit tests. You can run the tests with the following commands:

Using Maven:
```sh
./mvnw test
```

## ![Usage Example](https://img.icons8.com/fluency/15/000000/code.png) Usage Example

Here is an example of how to use the API to manage client information:

1. **Create a Client**

   Send a POST request to the `/clientes` endpoint with the following JSON payload:

   ```json
   {
     "nome": "João Silva",
     "cpf": "123.456.789-00",
     "idade": 80,
     "data_nascimento": "1990-01-01",
     "uf": "SP",
     "renda_mensal": 2500.00,
     "email": "joao.silva@example.com",
     "telefone_whatsapp": "11999999999"
   }
   ```

2. **Response**

   The API will respond with a JSON object indicating the client details and a unique identifier:

   ```json
   {
     "id": "123e4567-e89b-12d3-a456-426614174000",
     "nome": "João Silva",
     "cpf": "123.456.789-00",
     "idade": 80,
     "data_nascimento": "1990-01-01",
     "uf": "SP",
     "renda_mensal": 2500.00,
     "email": "joao.silva@example.com",
     "telefone_whatsapp": "11999999999"
   }
   ```

## ![API Documentation](https://img.icons8.com/fluency/19/000000/book.png) API Documentation
The API documentation is available in the docs/swagger.json file. You can use Swagger UI to visualize and interact with the API.

link: http://localhost:8080/swagger-ui/index.html

![swagger.png](imagens/openapi.png)

### ![License](https://img.icons8.com/fluency/19/000000/law.png) License
This project is licensed under the Apache 2.0 License - see the LICENSE file for details.