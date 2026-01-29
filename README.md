# Hospital Appointment Management System (JDBC)

A console-based **Hospital Appointment Management System** developed using **Java**, **JDBC**, and **MySQL**.  
This project follows a **layered architecture (DTO–DAO–Service–UI)** and supports complete **CRUD operations** for managing hospital appointments.

---

## Features

- Add new appointments
- Fetch appointment details by ID
- View all appointments
- Update appointment information
- Delete appointments
- Business validations through service layer

---

## Technologies Used

- Java
- JDBC
- MySQL
- SQL

---

## Project Architecture

This project follows a **layered architecture** to ensure separation of concerns and maintainability.

- **DTO (Data Transfer Object)**  
  Transfers data between layers

- **DAO (Data Access Object)**  
  Handles all database operations using JDBC

- **Service Layer**  
  Contains business rules and validations

- **Main (UI Layer)**  
  Menu-driven console interface for user interaction

---

## Database Design

### Table: `appointments`

```sql
CREATE TABLE appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(100),
    doctor_name VARCHAR(100),
    appointment_date DATE,
    appointment_time TIME
);
