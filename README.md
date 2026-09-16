# Student Management System using Java

## 1. Project Overview

The **Student Management System** is a simple console-based Java application developed as a **Programming in Java** project.

The application helps manage student details and academic marks. It allows the user to add, view, search and delete students, enter marks, calculate academic performance, generate reports, save information to a file, and store/retrieve records using JDBC with SQLite.

The project is designed to demonstrate important concepts from the Programming in Java syllabus through a practical application.

---

## 2. Objectives

The main objectives of this project are:

- To manage student information using Java.
- To store and manage student records using `ArrayList`.
- To apply Object-Oriented Programming concepts.
- To enter marks and calculate total, percentage, grade and result.
- To handle invalid input using exception handling.
- To demonstrate file input/output operations.
- To demonstrate multithreading through report generation.
- To connect Java with an SQLite database using JDBC.
- To develop a simple and user-friendly menu-driven application.

---

## 3. Main Features

### 3.1 Student Management

The Student Management module provides the following operations:

- Add a new student
- View all students
- Search for a student using student ID
- Delete a student
- Store student information using Java objects

### 3.2 Marks Management

The Marks Management module provides:

- Enter student marks
- Validate marks
- Calculate total marks
- Calculate percentage
- Calculate grade
- Determine pass/fail result
- Update academic information

### 3.3 Reports and Storage

The application provides:

- Student performance report generation
- Saving records to a text file
- Storing records in an SQLite database
- Retrieving records from the database using JDBC

### 3.4 Error Handling

The application handles invalid input using:

- Input validation
- `try-catch` blocks
- Custom exception handling
- `InvalidMarksException`
- Meaningful error messages

---

## 4. Java Concepts Used

This project demonstrates concepts from the **Programming in Java** syllabus.

### Java Fundamentals

- Variables
- Data types
- Operators
- Input and output
- Conditional statements
- `switch`
- Loops
- `break`
- `continue`

### Object-Oriented Programming

- Classes and Objects
- Constructors
- Methods
- Encapsulation
- Inheritance
- Method Overriding
- Method Overloading
- Abstract Classes
- Interfaces
- Polymorphism
- `this` keyword
- `super` keyword
- `final`
- `enum`
- Packages

### Exception Handling

- Exceptions
- `try-catch`
- `throw`
- `throws`
- Custom exceptions
- Input validation

### Collections

- Collections Framework
- List interface
- `ArrayList`

### File I/O

- Character streams
- File writing
- `FileWriter`
- `PrintWriter`

### Multithreading

- Thread creation
- Thread execution
- Report generation using a separate thread

### JDBC

- JDBC API
- Database connection
- SQLite JDBC driver
- `Connection`
- `PreparedStatement`
- `Statement`
- `ResultSet`
- SQL operations

---

## 5. Project Structure

```text
StudentManagementSystem/
│
├── src/
│   └── studentmanagement/
│       ├── Main.java
│       ├── Person.java
│       ├── Student.java
│       ├── Marks.java
│       ├── StudentManager.java
│       ├── Report.java
│       ├── Reportable.java
│       ├── FileManager.java
│       ├── DatabaseManager.java
│       ├── ReportThread.java
│       └── InvalidMarksException.java
│
├── lib/
│   ├── sqlite-jdbc-3.46.1.0.jar
│   └── slf4j-api-2.0.13.jar
│
├── screenshots/
│   ├── figure_1.png
│   ├── figure_2.png
│   ├── figure_3.png
│   ├── figure_4.png
│   ├── figure_5.png
│   └── figure_6.png
│
├── reports/
│   └── sample-output.txt
│
├── database.sql
├── statement.md
├── pom.xml
└── README.md