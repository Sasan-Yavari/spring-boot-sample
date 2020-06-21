Weather Service
---

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the
result in a database.

### Requirements

- Jdk 1.8 or higher
- Maven
- Postgres
- Docker (Optional)

### How to configure

1. [Sign up](https://openweathermap.org/appid) to the openweathermap and get an API key.
2. Set the `com.weather.openweathermap.api_key` configuration property using your API key in the following file.

    ```
    src/main/resources/application.yml
    ```

3. Run the `PostgreSQL` and set the datasource configuration properties in the following files:

    ```
    src/main/resources/application.yml
    src/main/resources/application-docker.yml
    ```

### How to build and run

#### As a normal java application

```
mvn clean package
java -jar target/weather-service-x.x.x-SNAPSHOT.jar
```

#### As a stand-alone Spring Boot service 

```
mvn clean package
mvn spring-boot:run
```

#### As a docker image

```
cd bin
chmod +x docker-run.sh
./docker-run.sh
```

### Swagger api doc

After running the service, open the following url in the browser:

```
http://host:port/v2/api-docs
```

### How to call

Simply open the following url in your browser:

```
http://host:port/weather?city=cityName
```

### Important Note

The default port is `8080`