# uniport-api

Open source API for community platform.

## Requirements

- Java 17
- Maven
- Docker
- Docker Compose

## Running the project

Create a file named `secrets.yaml` in the resource folder and add the following content:

```shell
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/citizix_db
    username: citizix_user
    password: S3cret
secret.key: "S3cret"
```

Run the following command to start the database:

```shell
docker-compose up
```

After the container is up, run the following command to start the server:

```shell
mvn spring-boot:run
```

> Note: The server will be running on port 8082 and it will populate the database
