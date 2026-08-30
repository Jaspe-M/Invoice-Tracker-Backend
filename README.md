# Budget Tracker Backend

A Spring Boot REST API built to serve the [budget tracking frontend](https://github.com/Jaspe-M/invoice-tracker-frontend), managing company budgets, 
department allocations, and invoice submissions for both manager and employee roles. The backend is seeded with demo data and only exposes GET 
endpoints to keep the data clean and consistent for everyone visiting the demo. All interactions like approvals, rejections, and budget changes happen locally in the frontend 
and reset to the original data on page refresh. The database is hosted on Supabase using PostgreSQL.

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
```