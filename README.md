## Rewards-Calculator-RestSpring Boot Rewards Service APIful


This is a Spring Boot application implementing a rewards service API. It allows you to manage customers and their transactions, calculating reward points based on a defined reward structure.

### Features:
- Manages customer information (name and ID). 
- Tracks customer transactions (total amount and description). 
- Calculates reward points based on transaction amounts (configurable logic).
- Retrieves a list of all customers.
- Retrieves a specific customer by ID.

### Technology Stack:
- Spring Boot
- JPA (for data persistence)
- Jackson (for JSON serialization/deserialization)

### Running the Application:
- Clone the project.
- Ensure you have Maven and Java installed.
- Verify Maven installation by running mvn -v in a terminal.
  - If you don't have Maven installed, you can download it from https://maven.apache.org/download.cgi.
  - If you don't have Java installed, you can download it from https://www.oracle.com/java/technologies/javase-jdk11-downloads.html.
- Run mvn clean install (or your preferred build command) to build the project.
- Run the application using java -jar target/rewards-calculator-0.0.1-SNAPSHOT.jar (replace the filename with the actual generated JAR file name).
- From Browser or Postman connect to http://localhost:8080/api/v1/rewards/customers
- From Browser or Postman connect to http://localhost:8080/api/v1/rewards/customers/{id}

### API Endpoints:
| Endpoint                       | Method | Description                          |
|--------------------------------|--------|--------------------------------------|
| /api/v1/rewards/customers      | Get    | Retrieves a list of all customers.   |
| /api/v1/rewards/customers/{id} | Get    | Retrieves a specific customer by ID. |

### Response Codes:
| Code             | Description                          |
|------------------|--------------------------------------|
| 200 OK           | Success                              |
| 404 Not Found    | Failure(Customer/Resource not found) |
| 500 Server Error | Internal Server Error                |
