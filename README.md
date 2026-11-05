# Student Management System

A Java-based web application designed to manage student records efficiently. The application uses Java, Servlets, JSP, JDBC and MySQL following the MVC architecture.

## Technologies Used

- Java 23
- JSP (JavaServer Pages)
- Jakarta Servlets
- JDBC
- MySQL
- Apache Maven
- Apache Tomcat 10.1
- HTML and CSS

## Features

- Admin Login
- Add New Students
- View Student Records
- Update Student Information
- Delete Student Records
- Search Students
- Database Connectivity

## Project Architecture

This project follows the Model-View-Controller (MVC) architecture.

- **Model:** Handles student data and business objects.
- **View:** JSP pages display the application interface.
- **Controller:** Servlets handle HTTP requests and responses.
- **DAO:** Handles database operations using JDBC.

## Project Structure

```text
StudentManagementSystem/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/nitish/
│       │       ├── controller/
│       │       ├── dao/
│       │       └── model/
│       │
│       └── webapp/
│           ├── WEB-INF/
│           ├── view/
│           └── index.jsp
│
├── pom.xml
├── .gitignore
└── README.md
```

## Requirements

- JDK 23 or compatible Java version
- Apache Maven
- MySQL Server
- Apache Tomcat 10.1
- IntelliJ IDEA

## How to Run the Project

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Configure the MySQL database connection.
4. Update the database username and password in the database connection configuration.
5. Create the required database and tables.
6. Build the project using Maven.
7. Generate the WAR file.
8. Deploy the WAR file on Apache Tomcat.
9. Open the application in your browser.

## Database

This application uses MySQL to store student and admin information.

Make sure MySQL is running and the required database tables are created before starting the application.

## Future Improvements

- Role-based authentication
- Improved user interface
- Input validation
- Password security improvements
- Better exception handling

## Author

**Nitish Kumar Mahato**

B.Tech - Computer Science and Engineering

## License

This project is developed for educational and learning purposes.
