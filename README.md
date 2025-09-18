# 📚 Student Management System (Java + MySQL)

A **console-based Student Management System** written in **Java (JDBC)** and backed by **MySQL**.  
This mini-project allows adding, viewing, updating, and deleting student information via a simple command-line interface.  

---

## 🚀 Features

- Add new students with name, email, and course.  
- View all students in tabular format.  
- Update student information by ID.  
- Delete student record by ID.  
- MySQL database integration using JDBC.  
- Runs entirely on Linux (Ubuntu/Debian tested).  

---

## 🛠️ Requirements

- **Java JDK 21+**  
- **MySQL 8.0+**  
- **MySQL Connector/J** (e.g., `mysql-connector-j-8.1.0.jar`)  

---

## ⚙️ Setup Instructions (Linux)

### 1️⃣ Create MySQL database & table

Log in to MySQL:

```bash
sudo mysql -u root
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(50)
);

Create MySQL user for the app

CREATE USER 'Dilhara3132'@'localhost' IDENTIFIED BY 'Dilhara@3132';
GRANT ALL PRIVILEGES ON studentdb.* TO 'Dilhara3132'@'localhost';
FLUSH PRIVILEGES;

Compile the Java program
javac -cp .:mysql-connector-j-8.1.0/mysql-connector-j-8.1.0.jar StudentManager.java

Run the program
java -cp .:mysql-connector-j-8.1.0/mysql-connector-j-8.1.0.jar StudentManager

Usage Example
=== Student Management ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Choose an option:


Project Structure

student-management-java/
├── StudentManager.java
├── mysql-connector-j-8.1.0/   # MySQL JDBC driver
└── README.md

👨‍💻 Author

R. P. T. Sandeepa Dilhara (electronic, communication, and IT undergraduate student )
