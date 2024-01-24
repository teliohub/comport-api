# uniport-api

Open source API for community platform.

## Requirements

- Java 17
- Maven
- Docker
- Docker Compose

## Running the project

First, run the following command to start the database:

```shell
docker-compose up
```

After the container is up, run the following command to start the server:

```shell
mvn spring-boot:run
```

> Note: The server will be running on port 8080 and it will populate the database