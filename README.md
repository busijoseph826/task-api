# Task Management REST API

A production-level REST API built with Spring Boot for managing tasks with full CRUD operations, pagination, filtering, JWT authentication, and global exception handling.

## Tech Stack

- **Java 21**
- **Spring Boot 3.5.15**
- **Spring Data JPA** — database operations
- **Spring Security** — authentication and authorization
- **JWT (JSON Web Token)** — stateless authentication
- **H2 Database** — in-memory database
- **Lombok** — reduces boilerplate code
- **Maven** — dependency management

## Project Structure
src/main/java/com/joseph/task_api/

├── auth/

│   ├── AuthController.java

│   ├── AuthService.java

│   ├── LoginRequest.java

│   └── RegisterRequest.java

├── config/

│   ├── JwtAuthFilter.java

│   ├── JwtService.java

│   └── SecurityConfig.java

├── controller/

│   └── TaskController.java

├── exception/

│   ├── GlobalExceptionHandler.java

│   └── TaskNotFoundException.java

├── model/

│   ├── Task.java

│   ├── TaskStatus.java

│   └── User.java

├── repository/

│   ├── TaskRepository.java

│   └── UserRepository.java

├── service/

│   └── TaskService.java

└── TaskApiApplication.java

## Features

- ✅ Full CRUD operations (Create, Read, Update, Delete)
- ✅ JWT Authentication (Register & Login)
- ✅ Protected API endpoints
- ✅ Pagination and sorting support
- ✅ Filter tasks by status
- ✅ Global exception handling
- ✅ Clean 404 / 500 error responses
- ✅ Auto timestamps (createdAt, updatedAt)
- ✅ Input validation
- ✅ Password encryption with BCrypt

## API Endpoints

### Auth Endpoints (Public)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and get JWT token |

### Task Endpoints (Protected — requires JWT token)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/tasks` | Create a new task |
| GET | `/api/tasks` | Get all tasks with pagination |
| GET | `/api/tasks/{id}` | Get task by ID |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |
| GET | `/api/tasks?status=OPEN` | Filter tasks by status |

## Task Status Values

| Status | Description |
|--------|-------------|
| `OPEN` | Task not started |
| `IN_PROGRESS` | Task in progress |
| `DONE` | Task completed |

## How to Run

### Prerequisites
- Java 21+
- Maven 3.8+

### Steps

1. Clone the repository
### Prerequisites
- Java 21+
- Maven 3.8+

### Steps

1. Clone the repository

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/tasks` | Create a new task |
| GET | `/api/tasks` | Get all tasks with pagination |
| GET | `/api/tasks/{id}` | Get task by ID |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |
| GET | `/api/tasks?status=OPEN` | Filter tasks by status |

## Task Status Values

| Status | Description |
|--------|-------------|
| `OPEN` | Task not started |
| `IN_PROGRESS` | Task in progress |
| `DONE` | Task completed |

## How to Run

### Prerequisites
- Java 21+
- Maven 3.8+

### Steps

1. Clone the repository
git clone https://github.com/busijoseph826/task-api.git
2. Navigate to project directory
cd task-api
3. Run the application
mvn spring-boot:run
4. App runs on
http://localhost:8080

## H2 Database Console

Access the in-memory database UI at:
http://localhost:8080/h2-console
| Field | Value |
|-------|-------|
| JDBC URL | `jdbc:h2:mem:taskdb` |
| Username | `sa` |
| Password | _(leave blank)_ |

## Authentication Flow
Register   → POST /api/auth/register → get JWT token
Login      → POST /api/auth/login    → get JWT token
Use token  → Add to every request header:

Authorization: Bearer <your_token>

## Sample Requests
### Register
POST http://localhost:8080/api/auth/register

Content-Type: application/json
{
"username": "joseph",
"password": "password123"
}

### Login
POST http://localhost:8080/api/auth/login

Content-Type: application/json
{
"username": "joseph",
"password": "password123"
}

### Response (both register and login)
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Create a Task (with token)
POST http://localhost:8080/api/tasks

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

Content-Type: application/json
{
"title": "Buy groceries",
"description": "Milk and eggs",
"status": "OPEN"
}
### Get All Tasks with Pagination
GET http://localhost:8080/api/tasks?page=0&size=5&sort=createdAt,desc

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
### Filter by Status
GET http://localhost:8080/api/tasks?status=OPEN

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
## Sample Task Response

```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk and eggs",
  "status": "OPEN",
  "createdAt": "2026-06-28T01:47:16",
  "updatedAt": "2026-06-28T01:47:16"
}
```

## Error Responses

### 401 Unauthorized (no token)
```json
{
  "status": 401,
  "error": "Unauthorized"
}
```

### 404 Not Found
```json
{
  "timestamp": "2026-06-28T01:47:16",
  "status": 404,
  "error": "Not Found",
  "message": "Task not found with id: 99"
}
```

## Author

**Busi Joseph** — Java Backend Developer
GitHub: https://github.com/busijoseph826
