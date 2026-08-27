# Budget Tracker Backend

REST API for managing company budgets, department allocations, and invoice submissions. Serves data entities and endpoints for manager and employee dashboards.

## Tech Stack
* Java 21
* Spring Boot
* PostgreSQL
* Maven

## Environment Variables
Set these variables in your IDE or local environment:

* DB_URL=jdbc:postgresql://localhost:5432/budgettrackerdb
* DB_USER=postgres
* DB_PASSWORD=your_password

## Local Development

Run the application with the Maven wrapper:

```bash
./mvnw spring-boot:run