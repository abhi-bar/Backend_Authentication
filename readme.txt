QUIZ SECURITY APPLICATION
=========================

Overview
--------
A secure quiz application built with Spring Boot that implements JWT-based authentication and role-based access control. Users can register, login, and access quiz questions based on their assigned roles.

Features
--------
- User registration and authentication
- JWT token-based security
- Role-based access control
- Quiz question management
- RESTful API endpoints

Technology Stack
---------------
- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Hibernate/JPA
- Database (MySQL/PostgreSQL)
- Maven

API Endpoints
------------
Authentication:
- POST /register - Register a new user
- POST /login - Authenticate and receive JWT token

Quiz Management:
- GET /api/question - Get quiz questions (requires user role)
- POST /api/save - Save new quiz questions (requires admin role)

Security Implementation
----------------------
- Password encryption using BCrypt
- JWT token authentication
- Role-based authorization
- Stateless session management

Getting Started
--------------
1. Configure database connection in application.properties
2. Build the project: mvn clean install
3. Run the application: mvn spring-boot:run

Usage
-----
1. Register a user via the /register endpoint
2. Login to obtain a JWT token
3. Include the token in subsequent requests:
   Authorization: Bearer <your_token>
4. Access protected endpoints based on your role

Configuration
------------
The application can be configured through application.properties:
- Database settings
- JWT secret key and expiration time
- Server port and other Spring Boot configurations


##Please refer to - https://github.com/GenieAshwani/Quiz-App-Spark2.0 for the actual project