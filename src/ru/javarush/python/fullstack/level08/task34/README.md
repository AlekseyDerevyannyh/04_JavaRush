# API Documentation

All URLs below are relative to the base URL of the running application, e.g. `http://localhost:5000`. Request and response bodies are JSON (`Content-Type: application/json`).

## User Management Endpoints

### 1. Create a User

- **HTTP Method**: POST
- **URL**: `/api/users`
- **Description**: Creates a new user in the system.
- **Request Body**:
  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```
- **Response**:
    - **201 Created**:
      ```json
      {
        "id": "integer",
        "username": "string",
        "email": "string"
      }
      ```
- **Example**:
  ```bash
  curl -X POST http://localhost:5000/api/users \
    -H "Content-Type: application/json" \
    -d '{"username": "alice", "email": "alice@example.com", "password": "secret123"}'
  ```
  Response (`201 Created`):
  ```json
  {
    "id": 1,
    "username": "alice",
    "email": "alice@example.com"
  }
  ```

### 2. Get User Details

- **HTTP Method**: GET
- **URL**: `/api/users/{id}`
- **Path Parameters**: `id` (path, integer) — ID of the user
- **Description**: Retrieves details of a specific user.
- **Response**:
    - **200 OK**:
      ```json
      {
        "id": "integer",
        "username": "string",
        "email": "string"
      }
      ```
- **Example**:
  ```bash
  curl -X GET http://localhost:5000/api/users/1
  ```
  Response (`200 OK`):
  ```json
  {
    "id": 1,
    "username": "alice",
    "email": "alice@example.com"
  }
  ```

### 3. Update User Information

- **HTTP Method**: PUT
- **URL**: `/api/users/{id}`
- **Path Parameters**: `id` (path, integer) — ID of the user
- **Description**: Updates information of an existing user.
- **Request Body**:
  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```
- **Response**:
    - **200 OK**:
      ```json
      {
        "id": "integer",
        "username": "string",
        "email": "string"
      }
      ```
- **Example**:
  ```bash
  curl -X PUT http://localhost:5000/api/users/1 \
    -H "Content-Type: application/json" \
    -d '{"username": "alice_smith", "email": "alice.smith@example.com", "password": "newsecret456"}'
  ```
  Response (`200 OK`):
  ```json
  {
    "id": 1,
    "username": "alice_smith",
    "email": "alice.smith@example.com"
  }
  ```

### 4. Delete a User

- **HTTP Method**: DELETE
- **URL**: `/api/users/{id}`
- **Path Parameters**: `id` (path, integer) — ID of the user
- **Description**: Deletes a user from the system.
- **Response**:
    - **204 No Content**
- **Example**:
  ```bash
  curl -X DELETE http://localhost:5000/api/users/1
  ```
  Response: `204 No Content` with an empty body.

## Task Management Endpoints

### 1. Create a Task

- **HTTP Method**: POST
- **URL**: `/api/tasks`
- **Description**: Creates a new task.
- **Request Body**:
  ```json
  {
    "title": "string",
    "description": "string",
    "due_date": "string"
  }
  ```
- **Response**:
    - **201 Created**:
      ```json
      {
        "id": "integer",
        "title": "string",
        "description": "string",
        "due_date": "string"
      }
      ```
- **Example**:
  ```bash
  curl -X POST http://localhost:5000/api/tasks \
    -H "Content-Type: application/json" \
    -d '{"title": "Write docs", "description": "Document the API endpoints", "due_date": "2026-10-15"}'
  ```
  Response (`201 Created`):
  ```json
  {
    "id": 1,
    "title": "Write docs",
    "description": "Document the API endpoints",
    "due_date": "2026-10-15"
  }
  ```

### 2. Get Task Details

- **HTTP Method**: GET
- **URL**: `/api/tasks/{id}`
- **Path Parameters**: `id` (path, integer) — ID of the task
- **Description**: Retrieves details of a specific task.
- **Response**:
    - **200 OK**:
      ```json
      {
        "id": "integer",
        "title": "string",
        "description": "string",
        "due_date": "string"
      }
      ```
- **Example**:
  ```bash
  curl -X GET http://localhost:5000/api/tasks/1
  ```
  Response (`200 OK`):
  ```json
  {
    "id": 1,
    "title": "Write docs",
    "description": "Document the API endpoints",
    "due_date": "2026-10-15"
  }
  ```

### 3. Update a Task

- **HTTP Method**: PUT
- **URL**: `/api/tasks/{id}`
- **Path Parameters**: `id` (path, integer) — ID of the task
- **Description**: Updates an existing task.
- **Request Body**:
  ```json
  {
    "title": "string",
    "description": "string",
    "due_date": "string"
  }
  ```
- **Response**:
    - **200 OK**:
      ```json
      {
        "id": "integer",
        "title": "string",
        "description": "string",
        "due_date": "string"
      }
      ```
- **Example**:
  ```bash
  curl -X PUT http://localhost:5000/api/tasks/1 \
    -H "Content-Type: application/json" \
    -d '{"title": "Write docs", "description": "Document and review the API endpoints", "due_date": "2026-10-20"}'
  ```
  Response (`200 OK`):
  ```json
  {
    "id": 1,
    "title": "Write docs",
    "description": "Document and review the API endpoints",
    "due_date": "2026-10-20"
  }
  ```

### 4. Delete a Task

- **HTTP Method**: DELETE
- **URL**: `/api/tasks/{id}`
- **Path Parameters**: `id` (path, integer) — ID of the task
- **Description**: Deletes a task from the system.
- **Response**:
    - **204 No Content**
- **Example**:
  ```bash
  curl -X DELETE http://localhost:5000/api/tasks/1
  ```
  Response: `204 No Content` with an empty body.
