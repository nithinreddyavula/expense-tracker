# Expense Tracker REST API

A RESTful backend application to manage daily expenses.

## Tech Stack
- Java 17
- Spring Boot 3.2
- Spring Data JPA
- MySQL
- Maven

## Features
- Add, view, update, delete expenses
- Filter by category
- Search by keyword
- Input validation with proper error messages
- Global exception handling

## API Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/expenses | Get all expenses |
| GET | /api/expenses/{id} | Get expense by ID |
| POST | /api/expenses | Create new expense |
| PUT | /api/expenses/{id} | Update expense |
| DELETE | /api/expenses/{id} | Delete expense |
| GET | /api/expenses/category/{category} | Filter by category |
| GET | /api/expenses/search?keyword=xyz | Search by keyword |

## Recent Updates

I implemented pagination and sorting on the GET /api/expenses endpoint.
This prevents the server from overloading when the database has thousands
of records. Clients can request specific pages and sorted data using query
parameters like `?page=0&size=5&sort=amount,asc`.

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/expenses?page=0&size=5&sort=amount,asc | Get paginated and sorted expenses |
| GET | /api/expenses/{id} | Get expense by ID |
| POST | /api/expenses | Create new expense |
| PUT | /api/expenses/{id} | Update expense |
| DELETE | /api/expenses/{id} | Delete expense |s

## Author
Avula Nithin Kumar Reddy