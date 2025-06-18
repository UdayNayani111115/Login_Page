# Java Login & Registration System

This is a standalone Java-based login and registration application that allows users to register and then log in securely. It’s designed for beginners who want to understand full-stack flow using Java, JDBC, MySQL, and simple web technologies.

## 🔧 Features

- Register new users (with validation)
- Authenticate existing users
- Store user data in a MySQL database
- Simple and clean frontend using HTML and CSS
- Organized folder structure and easy-to-read code

## 🛠️ Tech Stack

- **Backend:** Java
- **Database:** MySQL
- **Database Access:** JDBC
- **Frontend:** HTML, CSS

## 💾 How to Set It Up

1. **Clone or Download the Repository**  
   Simply download this project or clone it using Git.

2. **Set Up the Database**
   Create a MySQL database and table like below:
   ```sql
   CREATE DATABASE user_db;

   USE user_db;

   CREATE TABLE users (
       id INT PRIMARY KEY AUTO_INCREMENT,
       username VARCHAR(50) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL,
       email VARCHAR(100)
   );
📁 Project Structure
bash
Copy
Edit
project-folder/
├── index.html         # Login page

├── register.html      # Registration page
├── style.css          # CSS styling
├── DBConnection.java  # JDBC connection logic
├── LoginServlet.java  # Handles login
├── RegisterServlet.java # Handles registration
└── README.md          # Project documentation

🚀 Future Enhancements
Add password hashing (e.g., using BCrypt)

Add session tracking and logout

Add validation on both frontend and backend

Convert it to a Maven or Spring Boot project

👨‍💻 Author
Uday Kiran Nayani

Feel free to use, modify, or build on top of this project for learning purposes or your own applications.


