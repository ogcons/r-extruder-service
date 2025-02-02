# R-extruder


## Overview

This Spring Boot application allows users to post R scripts, which are then executed on the server. The result of the R script execution is a plot saved in a Word document, which is returned to the user. The backend part of the project is built using Java 21, SpringBoot, Gradle, R 4.3.2. Frontend is built in ReactJS using Node.js.

### Component diagram:
![](docs/Diagram.svg)
### Sequential diagram:
![](docs/Sequential-diagram.svg)
### Activity diagram:
![](docs/Activity-diagram.svg)
## Prerequisites

Before running the application, ensure that the following prerequisites are met:

- [Java 21](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/)
- [Spring Boot](https://start.spring.io/)
- [R 4.3.2](https://cran.r-project.org/)
- [Docker and Docker-Compose(Docker Desktop)](https://www.docker.com/products/docker-desktop/)
- [Node.js](https://nodejs.org/en/download)

## Configuration

Set Environment Variable R_EXECUTABLE to the binary of the R script.
For Windows Users(Default):
```
R_EXECUTABLE = C:\\Program Files\\R\\R-4.3.2\\bin\\Rscript.exe
```

Set Environment Variable WORKING_DIR to the desired working directory.
For Windows Users(Example):
```
WORKING_DIR = C:\Users\username\Desktop
```

### Build image from Dockerfile

Set environment variable in system variables, but set them for Linux environment
```
docker build -t r-extruder-service . --build-arg R_EXECUTABLE=$env:R_EXECUTABLE --build-arg WORKING_DIR=$env:WORKING_DIR
```

### Start Localstack and AWS CLI

Start docker and run this command in the root of your project:
```bash 
docker compose -f docker-compose-dev.yml up
```

### Start frontend
- Enter environment variables into your system environment
- Use these commands in project directory:

```bash 
cd r-extruder-ui
npm install
npm start
```

### Start backend
- Enter environment variables into your system environment
- Use these commands in project directory:

```bash 
cd r-extruder-service
./gradlew clean build
java -jar build/libs/r-extruder-service-0.0.1-SNAPSHOT.jar
```

To test the endpoints: 
- Use Swagger documentation - http://localhost:8080/swagger-ui/index.html

## License

This project is licensed under the MIT License - see the LICENSE file for details.
