
# Hospital Management Application

This is a Spring Boot-based Hospital Management Application that uses MySQL as the database to manage patient records. The application provides RESTful API endpoints for managing patient data.

## Features
- Create, Read, Update, and Delete (CRUD) operations for patient records.
- MySQL database for storing patient information.
- Dockerized setup for easy development and deployment.

## API Endpoints

### 1. **Get all patients**

- **Endpoint**: `GET /hospital/patients/`
- **Description**: Fetches a list of all patients.
- **Response**:
  ```json
  [
    {
      "patientId": 1,
      "name": "John Doe",
      "age": "45",
      "disease": "Flu"
    },
    {
      "patientId": 2,
      "name": "Jane Smith",
      "age": "60",
      "disease": "Pneumonia"
    }
  ]
  ```

### 2. **Get patient by ID**

- **Endpoint**: `GET /hospital/patients/{patient_id}`
- **Description**: Fetches a patient by their ID.
- **Request Example**: `GET /hospital/patients/1`
- **Response**:
  ```json
  {
    "patientId": 1,
    "name": "John Doe",
    "age": "45",
    "disease": "Flu"
  }
  ```

### 3. **Save a new patient**

- **Endpoint**: `POST /hospital/patients/`
- **Description**: Adds a new patient to the database.
- **Request Body**:
  ```json
  {
    "name": "Alice Brown",
    "age": "30",
    "disease": "Diabetes"
  }
  ```
- **Response**:
  ```json
  {
    "patientId": 3,
    "name": "Alice Brown",
    "age": "30",
    "disease": "Diabetes"
  }
  ```

### 4. **Update an existing patient**

- **Endpoint**: `PUT /hospital/patients/{patient_id}`
- **Description**: Updates an existing patient's information.
- **Request Example**: `PUT /hospital/patients/1`
- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "age": "46",
    "disease": "Cold"
  }
  ```
- **Response**:
  ```json
  {
    "patientId": 1,
    "name": "John Doe",
    "age": "46",
    "disease": "Cold"
  }
  ```

### 5. **Delete a patient**

- **Endpoint**: `DELETE /hospital/patients/{patient_id}`
- **Description**: Deletes a patient from the database.
- **Request Example**: `DELETE /hospital/patients/1`
- **Response**: `200 OK` (If successfully deleted)

## Setup and Installation

### Prerequisites

- Docker
- Docker Compose
- JDK 21 or later (if you want to build manually)

### 1. Clone the repository

Clone the repository to your local machine.

```bash
git clone https://github.com/kishara98/HospitalManagementApplication.git
cd HospitalManagementApplication
```

### 2. Docker Setup

Ensure that you have Docker and Docker Compose installed. You can verify this by running:

```bash
docker --version
docker-compose --version
```

### 3. Build and Run with Docker Compose

Run the following command to build and start both the Spring Boot application and MySQL database:

```bash
docker-compose up --build
```

This will:
- Build the Docker images for both the Spring Boot app and MySQL.
- Start the containers and set up networking between them.

### 4. Access the Application

Once the application is running, you can access the Spring Boot application at:

```
http://localhost:8080
```

MySQL will be running at:

```
localhost:3306
```

### 5. Stopping the Containers

To stop the running containers, use:

```bash
docker-compose down
```

This will stop and remove the containers, but the data in MySQL will be preserved.

## Database Configuration

The Spring Boot application is configured to connect to MySQL. The default MySQL database configuration can be found in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://mysql:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=****
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

If you need to change the MySQL configuration, modify this file accordingly.

## Contributing

Feel free to fork the repository and submit pull requests for bug fixes, new features, or improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
