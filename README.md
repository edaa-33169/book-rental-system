# Online Book Rental System

## Overview
The Online Book Rental System is a web application designed to facilitate the rental and management of books. Users can browse available books, rent them, leave reviews, and view information about the authors. The system aims to simplify the process of book rentals while providing additional functionalities like user reviews and author management.

## Features

### Users
- Users can create an account.
- View the list of all users.
- Manage their own rentals and reviews.

### Books
- Add, update, or delete books.
- View available books with details like title, author, genre, and availability status.
- Rent books and manage the return process.

### Rentals
- Users can rent books by selecting from the available list.
- Tracks rental start and return dates.
- Automatically updates book availability.

### Reviews
- Users can leave reviews and ratings for books they have rented.
- View a list of reviews for a specific book.

### Authors
- Add authors with details such as name and bio.
- View a list of authors and their respective books.

## Technologies Used
- **Programming Language:** Java
- **Framework:** Spring Boot
- **Database:** H2 (for testing) / MySQL (for deployment)
- **ORM:** Hibernate / JPA
- **Build Tool:** Maven
- **Other Tools:** Postman for API testing

## Installation

### Prerequisites
1. Java Development Kit (JDK) 11 or higher.
2. Maven installed on your system.
3. Database setup (H2 or MySQL).

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository/book-rental-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd book-rental-system
   ```
3. Update the database configuration in `src/main/resources/application.properties`:
   For H2:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   ```
   For MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bookrental
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. The application will be accessible at:
   ```http://localhost:8080
```

## API Endpoints

### Users
- **GET /api/users**: Retrieve all users.
- **GET /api/users/{id}**: Retrieve a specific user by ID.
- **POST /api/users**: Create a new user.
- **DELETE /api/users/{id}**: Delete a user by ID.

### Books
- **GET /api/books**: Retrieve all books.
- **GET /api/books/{id}**: Retrieve a specific book by ID.
- **POST /api/books**: Add a new book.
- **DELETE /api/books/{id}**: Delete a book by ID.

### Rentals
- **GET /api/rentals**: Retrieve all rentals.
- **POST /api/rentals**: Create a new rental.
- **GET /api/rentals/{id}**: Retrieve a specific rental by ID.
- **DELETE /api/rentals/{id}**: Delete a rental by ID.

### Reviews
- **GET /api/reviews**: Retrieve all reviews.
- **POST /api/reviews**: Add a new review.
- **GET /api/reviews/book/{bookId}**: Retrieve reviews for a specific book.
- **GET /api/reviews/user/{userId}**: Retrieve reviews by a specific user.
- **DELETE /api/reviews/{id}**: Delete a review by ID.

### Authors
- **GET /api/authors**: Retrieve all authors.
- **GET /api/authors/{id}**: Retrieve a specific author by ID.
- **POST /api/authors**: Add a new author.
- **DELETE /api/authors/{id}**: Delete an author by ID.

## Database Schema

### Tables and Relationships
- **Users**: Contains user details (ID, name, email, password).
- **Books**: Stores book details (ID, title, genre, availability, author).
- **Rentals**: Tracks rentals (ID, user, book, rental date, return date).
- **Reviews**: Stores reviews (ID, user, book, comment, rating).
- **Authors**: Contains author details (ID, name, bio).

Relationships:
- `Book` has a `ManyToOne` relationship with `Author`.
- `Rental` has a `ManyToOne` relationship with `User` and `Book`.
- `Review` has a `ManyToOne` relationship with `User` and `Book`.

## Testing
- The application has been tested using Postman for all CRUD operations.
- Basic unit tests are implemented for the core services (Rental, Review, Book).
- Example test scenarios:
  - Renting a book updates its availability.
  - Adding a review links it correctly to the user and book.

## Future Enhancements
- Implement authentication and authorization for secure access.
- Add pagination for large datasets (e.g., books, reviews).
- Enhance the front-end with a React or Angular interface.



