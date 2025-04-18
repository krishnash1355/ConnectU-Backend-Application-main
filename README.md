# <h1 align="center"> ConnectU Back-end Application </h1>

<p align="left">

## Overview

The ConnectU Backend Application is a robust and scalable Spring Boot-based backend system designed to power a social media platform with features. It provides a comprehensive set of RESTful API endpoints for user management, post creation, commenting, liking, and more.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java 21
- **Database:** MySQL
- **Build Tool:** Maven
- **Documentation:** SpringDoc OpenAPI (Swagger UI)
- **Email Handling:** JavaMail API



## Dependencies Used

The project utilizes the following dependencies:

- **Spring Boot Starter Data JPA**: Simplifies database access using Spring Data repositories.

- **Spring Boot Starter Web**: Provides support for building web applications, including RESTful APIs.

- **MySQL Connector/J (Runtime Dependency)**: The MySQL JDBC driver for connecting to MySQL databases.

- **Project Lombok (Optional)**: A library for reducing boilerplate code, such as getters and setters.

- **Spring Boot Starter Test (For Testing)**: Provides support for testing Spring Boot applications.

- **Springdoc OpenAPI (Swagger UI)**: Adds Swagger UI for documenting and testing API endpoints.

- **Spring Boot Starter Validation**: Includes validation support for request data binding and response data rendering.

- **JavaMail API**: Used for sending emails.

- **Other Dependencies:** Various other dependencies are included in the `pom.xml` file for specific functionalities, such as Jackson for JSON serialization, Spring Web for web-related features, and more.

Please refer to the project's `pom.xml` file for a comprehensive list of all dependencies and their respective versions.

## Project Structure

The project follows a clean and organized structure:

- **Main Application Class:** `ConnectUBackendApplication.java` serves as the entry point for the Spring Boot application.
- **Entities:** The application includes entities for `User`, `Post`, `Comment`, and `Like`, each with corresponding repository interfaces.
- **Security Configuration:** Spring Security is employed to secure the application with authentication and authorization.
- **Database Configuration:** The `application.properties` file configures the database connection and Spring Data JPA properties.
- **Controller Classes:** These classes define and document the RESTful API endpoints for user management, posts, comments, and likes.
- **Service Classes:** Business logic is implemented in service classes, ensuring separation of concerns.
- **Repository Interfaces:** Spring Data JPA repository interfaces manage data access to the underlying database.


## Data Flow

The ConnectU Backend Application follows a structured data flow that encompasses user management, post creation, commenting, and liking. Here's an overview of how data flows through the application:

1. **User Registration and Authentication:**

    - Users start by registering accounts using their email and password.
    - The application securely stores user credentials.
    - Upon subsequent visits, users authenticate themselves using their registered credentials.
    - Spring Security manages user authentication and authorization.

2. **User Profile Management:**

    - Authenticated users can update their profiles, including usernames, profile pictures, and bios.
    - User profiles are stored as `User` entities in the database.

3. **Post Creation and Retrieval:**

    - Authenticated users can create posts, including images and captions.
    - Posts are stored as `Post` entities in the database.
    - Users can retrieve their own posts and posts from profiles they follow.
    - Public posts are accessible to all users.

4. **Commenting on Posts:**

    - Users can comment on posts created by themselves or others.
    - Comments are stored as `Comment` entities in the database.
    - Users can view comments associated with each post.

5. **Liking Posts:**

    - Users can like posts, indicating their appreciation.
    - Likes are stored as `Like` entities in the database.
    - Users can see the number of likes for each post.

6. **Security:**

    - Spring Security ensures secure access to user data and endpoints.
    - Passwords are securely hashed and stored.
    - Authentication tokens are generated and validated for secure API access.

7. **Data Persistence:**

    - User profiles, posts, comments, and likes are persisted in a relational database.
    - The application uses JPA (Java Persistence API) for database operations.
    - Entities are mapped to database tables for data storage.

8. **RESTful API Endpoints:**

    - The application exposes RESTful API endpoints to interact with user data, posts, comments and likes.
    - Each endpoint is documented and adheres to REST principles.



## RESTful API Endpoints

The application provides a wide range of RESTful API endpoints for social media functionalities:

### User Management

- **Register User:** `POST /api/users/register`
- **Login User:** `POST /api/users/login`
- **Get User Profile:** `GET /api/users/{userId}`
- **Update User Profile:** `PUT /api/users/{userId}`
- **Delete User Account:** `DELETE /api/users/{userId}`

### Post Management

- **Create Post:** `POST /api/posts`
- **Get All Posts:** `GET /api/posts`
- **Get Post by ID:** `GET /api/posts/{postId}`
- **Update Post:** `PUT /api/posts/{postId}`
- **Delete Post:** `DELETE /api/posts/{postId}`

### Comment Management

- **Add Comment:** `POST /api/comments`
- **Get Comments for Post:** `GET /api/comments/{postId}`
- **Update Comment:** `PUT /api/comments/{commentId}`
- **Delete Comment:** `DELETE /api/comments/{commentId}`

### Like Management

- **Like Post:** `POST /api/likes/{postId}`
- **Get Likes for Post:** `GET /api/likes/{postId}`
- **Unlike Post:** `DELETE /api/likes/{postId}`

The API endpoints are fully documented and support the core features of a social media platform.

## Database Design

The application employs a relational database design with tables for user profiles, posts, comments, and likes. Key attributes include:

### User Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| userId             | INT             | Unique identifier for each user       |
| username           | VARCHAR(255)    | User's username                        |
| email              | VARCHAR(255)    | User's email address                   |
| profilePictureUrl  | VARCHAR(255)    | URL to the user's profile picture     |

### Post Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| postId             | INT             | Unique identifier for each post       |
| userId             | INT             | User ID of the post creator           |
| caption            | TEXT            | Caption for the post                  |
| imageUrl           | VARCHAR(255)    | URL to the post image                  |

### Comment Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| commentId          | INT             | Unique identifier for each comment    |
| userId             | INT             | User ID of the comment creator        |
| postId             | INT             | Post ID to which the comment belongs  |
| text               | TEXT            | Text of the comment                   |

### Like Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| likeId             | INT             | Unique identifier for each like       |
| userId             | INT             | User ID of the like creator           |
| postId             | INT             | Post ID to which the like belongs     |


## Database Details

The ConnectU Backend Application utilizes a MySQL database to persist user data, posts, comments, likes, and other relevant information. Here are the key details about the database:

- **Database Engine:** MySQL
- **Database Schema:** ConnectUDB

### Schema Design

The application's database is designed with several tables to store various types of data:

1. **Users Table (`user`):**

    - Stores user profile information, including user ID, username, email, password, profile picture URL, and bio.
    - Manages user registration, authentication, and profile management.

2. **Posts Table (`post`):**

    - Contains posts created by users, including post ID, user ID (foreign key), image URL, caption, and creation timestamp.
    - Handles the creation and retrieval of user posts.

3. **Comments Table (`comment`):**

    - Stores comments made on posts, with fields such as comment ID, user ID (foreign key), post ID (foreign key), comment text, and creation timestamp.
    - Manages the interaction between users on post comments.

4. **Likes Table (`like`):**

    - Records user likes on posts, including like ID, user ID (foreign key), post ID (foreign key), and creation timestamp.
    - Tracks user engagement and post popularity.

5. **Followers Table (`follower`):**

    - Manages user following relationships, with fields for follower ID (the user who follows) and followee ID (the user being followed).
    - Supports user interaction, such as viewing followed users' posts.

### Entity Relationships

The database tables are linked through foreign key relationships to maintain data integrity:

- The `user` table is referenced by the `post`, `comment`, and `like` tables to associate user data with posts, comments, and likes.
- The `follower` table establishes user-following relationships, allowing users to follow and view posts from other users.

This schema design ensures that user data, posts, comments, and likes are logically organized and can be efficiently queried for various application features.

### Database Configuration

The database connection properties are specified in the `application.properties` file, including the database URL, username, and password. Here is an example configuration for MySQL:

## Data Structures Used

The project utilizes the following data structures:

### User Class

The `User` class defines the structure for user data and includes the following fields:

- `userId` (User ID): An integer that serves as a unique identifier for each user.
- `username` (Username): A string representing the user's username.
- `email` (Email): A string containing the user's email address.
- `profilePictureUrl` (Profile Picture URL): A string with the URL to the user's profile picture.

### Post Class

The `Post` class defines the structure for post data and includes the following fields:

- `postId` (Post ID): An integer that serves as a unique identifier for each post.
- `userId` (User ID): An integer indicating the user who created the post.
- `caption` (Caption): A text field representing the caption for the post.
- `imageUrl` (Image URL): A string with the URL to the post's image.

### Comment Class

The `Comment` class defines the structure for comment data and includes the following fields:

- `commentId` (Comment ID): An integer that serves as a unique identifier for each comment.
- `userId` (User ID): An integer indicating the user who created the comment.
- `postId` (Post ID): An integer indicating the post to which the comment belongs.
- `text` (Text): A text field representing the content of the comment.

### Like Class

The `Like` class defines the structure for like data and includes the following fields:

- `likeId` (Like ID): An integer that serves as a unique identifier for each like.
- `userId` (User ID): An integer indicating the user who created the like.
- `postId` (Post ID): An integer indicating the post to which the like belongs.

### ArrayList

The project utilizes the `ArrayList` data structure to manage lists of entities efficiently in various parts of the application. `ArrayList` provides dynamic sizing and efficient element retrieval, making it suitable for storing and processing user profiles, posts, comments, and likes.

These data structures enable the application to efficiently organize and manipulate user data while maintaining data integrity.

### Key Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven


### Project Structure

The project follows a well-structured architecture, promoting clean code and separation of concerns. It includes entities, controllers, services, and repositories for different aspects of the application.


### RESTful API Endpoints

The application provides a comprehensive set of RESTful API endpoints to handle user management, posts, comments and likes. Each endpoint is documented and supports the core features of a social media platform.

### Database Design

The application employs a relational database design with tables for user profiles, posts, comments, and likes. This design ensures data integrity and provides a structured approach to managing user-generated content.

### Data Structures Used

The project utilizes data structures such as the `User`, `Post`, `Comment`, and `Like` classes, along with `ArrayLists`, to efficiently manage and process user data.

### Key Features

- User registration and login
- User profile management
- Post-creation, retrieval, and modification
- Commenting on posts
- Liking posts
- Robust security with Spring Security
- Well-structured codebase with clean separation of concerns