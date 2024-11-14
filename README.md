## airbnb-service-test
### Database structure
- ![airbnb_db_diagram.png](docs%2Fairbnb_db_diagram.png)

## Prerequisite
For building and running the application you need:
- JDK 21 or later
- Maven
- IntelliJ
- Docker
- Postgres

## Setup
### Setup variables environment
- MacOS
    - Open terminal and execute statement:
      ```shell
      echo export "JAVA_HOME=\$(/usr/libexec/java_home)" >> ~/.zshenv
      ```
    - Force to close the terminal by pressing `command + Q` then open the terminal again and check the result with a command:
      ```shell
      echo $JAVA_HOME
      ```
- Windows
    - Open Command Prompt (make sure you Run as administrator so you're able to add a system environment variable).
    - Set the value of the environment variable to your JDK installation path as follows:
      ```shell
      setx /m JAVA_HOME "C:\Program Files\Java\{your jdk path}"
      ```
    - Restart Command Prompt to reload the environment variables then use the following command to check the it's been added correctly.
      ```shell
      echo %JAVA_HOME%
      ```
      You should see the path to your JDK installation.

## Build and run the application locally

### Build project
  ```shell
    mvn clean install
  ```
### Build project skip Tests
  ```shell
    mvn clean install -Dmaven.test.skip=true
  ```

### How to build and run docker image
- Run docker image
- Run Zipkin by docker image:
  ```shell
     docker-compose up
  ```
### Run Spring Boot Application
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the {module}Application class from your IDE.

{module}: It's the prefix name of the project that you would like to run. For example, I would to run project, the application name would be `AirbnbApplication`

Or go to your child project and run the following command in a terminal:
```shell
mvn spring-boot:run
```

### API documentation
```shell
http://localhost:8080/swagger-ui/index.html
```

## Access the API
Base URL: http://localhost:8080

## User Authentication
### Register a New User
- Endpoint: POST /api/v1/auth/register
- Request Body
```json
    {
    "username": "teedinh",
    "email": "teedinh.com",
    "password": "12345",
    "phoneNumber": "+84385188858"
    }
```
- Response
```json
    {
      "id": 1,
      "username": "teedinh",
      "email": "teedinh.com",
      "phoneNumber": "+84385188858"
    }
```
### Using the JWT Token
Include the token in request headers:
```shell
    Authorization: Bearer your_jwt_token_here
```

## API Endpoints
### Listing Management
- Create a Listing
  - Endpoint: POST /api/v1/listings
  - Request Body
  ```json
    {
      "hostId": 1,
      "title": "cccCozy Apartment in the Heart of NYC",
      "description": "A charming one-bedroom apartment with a beautiful view of the city.",
      "propertyTypeId": 1,
      "guests": 1,
      "bedrooms": 1,
      "bathrooms": 1,
      "beds": 1,
      "pricePerNight": 150.00,
      "cleaningFee": 20.00,
      "locationId": 1,
      "isActive": true,
      "categoryIds": [1]
    }
  ```
- Get All Listings
  - Endpoint: GET /api/listings
  - Query Params: page, size, sort, city, name
  ```shell
    GET /api/listings?page=0&size=10 
  ```
- Update a Listing
  - Endpoint: PUT /api/v1/listings/{id}
Delete a Listing
  - Endpoint: DELETE /api/v1/listings/{id}