# Student Management System (Spring Boot CRUD)

Spring Boot REST API project that performs CRUD operations for managing student records. It demonstrates backend development using Spring Boot, Spring Data JPA, and RESTful APIs

## Technologies Used
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL (or H2 Database)
- Maven
- Postman (for testing)

🏗️ Architecture
Controller → Service → Repository → Database

## Features
- Create Student
- Read All Students
- Read Student by ID
- Update Student
- Delete Student
- REST API integration
- JPA + Hibernate integration

## API Endpoints

### Add Student
POST /students

### Get All Students
GET /students

### Put and Patch for the Students
PUT /students/{id}
PATCH /students/{id}

Request body
```bash
{
  "name": "Updated Name",
  "email": "updated@gmail.com"
}
```

### Delete the student
DELETE /students/{id}


▶️ How to Run the Project

Step 1: Clone the repository
```bash
git clone https://github.com/your-username/studentapp.git
```

Step 2: Navigate to project folder
```bash
cd studentapp
```

Step 3: Run the Application

```bash
mvn spring-boot:run
```

## Database Configuration

Update `application.properties` with your PostgreSQL credentials.

## Author

Manikandan S
