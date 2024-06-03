# TaskApp

## Description
TaskApp is a task management application that allows users to create new tasks and get the list of tasks already created.

## Functional Requirements

1. **Task Creation**: Users can create a new task by providing a title, description, due date, and optional tags.
2. **Task Listing**: Users can view a list of all existing tasks, including their title, description, due date, and status.

## Technical Requirements

- Use Spring Boot for application development.
- Apply the principles of hexagonal architecture.
- Use MongoDB as the database.
- Set up the development environment using Docker, including containers for the application and the chosen database.
- Implement acceptance tests to validate the application's behavior.

## Prerequisites

- Docker
- Docker Compose
- Postman (optional, testing purposes)

## Building and Running the Application

1. **Clone the repository**:
    ```sh
    git clone https://github.com/YuliyaKobruseva/TaskApp.git
    cd task-app
    ```

2. **Run the `run.bat` script**:\n
   This script will stop existing containers, build and start the new containers.
    ```sh
    ./run.bat
    ```
   If you are using a Unix-based system, you can run the following commands:
    ```sh
    docker-compose down -v
    docker-compose up --build -d
    ```
   Remove the `-v` flag if you want to keep the database data after stopping the containers.

3. **Access the application**:
    - The API will be available at `http://localhost:8080`

## Available Endpoints

- **Create Task**: `POST /tasks`
    ```json
    {
        "title": "Buy groceries",
        "description": "Buy milk, bread, and eggs",
        "dueDate": "2023-12-15",
        "tags": ["personal", "shopping"]
    }
    ```

- **List All Tasks**: `GET /tasks/all`

## Tests

Unit and integration tests are located in the `src/test/java` directory. Use the following command to run them:

```sh
./gradlew test
