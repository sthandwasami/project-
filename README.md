Secure Login Application

## Overview

The Secure Login Application is a Java-based desktop application that implements a user authentication system using Swing for the graphical user interface. This application allows users to register, log in, and view their information securely.

## Key Features

- **Secure User Registration**: Users can create accounts with unique usernames and passwords.
- **Authentication**: Users can log in using their registered credentials.
- **User Information Display**: After successful login, users are greeted with a welcome message and their registration number.
- **Responsive UI**: The application is designed with a user-friendly interface for seamless interaction.

## Architecture

The application is structured into several classes, each responsible for specific functionality:

1. **Main Class**: Initializes the application and displays the login frame.
2. **LoginFrame Class**: Manages the login interface and user authentication process.
3. **SignupFrame Class**: Handles the registration process, ensuring username uniqueness.
4. **UserManager Class**: Manages user data, including registration and validation logic.
5. **UserInfoFrame Class**: Displays user information upon successful login.

## Technologies Used

- **Java**: The programming language used to develop the application.
- **Swing**: For creating the graphical user interface.
- **HashMap**: Utilized for in-memory storage of user credentials.

## Installation and Setup

1. **Clone the Repository**: Use Git to clone the repository to your local machine.
   ```bash
   git clone https://github.com/your-repo-url.git
   ```
2. **System Requirements**:
   - Java Development Kit (JDK) 8 or higher.
   - An IDE such as IntelliJ IDEA or Eclipse for compilation.

3. **Compile the Code**: Open the project in your IDE and build the project to resolve dependencies.

4. **Run the Application**: Execute the `Main` class to start the application.

## User Credentials

- **Registration Number (used as Password)**: `h230487b`
- **Username**: During registration, choose a unique username.

## Security Considerations

- **In-Memory Storage**: User data is currently stored in a `HashMap`, which means data is lost when the application is closed. For production use, consider implementing a database for persistent storage.
- **Password Security**: Passwords are stored in plain text for demonstration purposes. In a real-world application, implement hashing (e.g., BCrypt) to secure user passwords.

## Contribution Guidelines

If you wish to contribute to this project:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request detailing your changes.

## Author

- **Name**: Nothando

## License

This project is open-source and available under the [MIT License](LICENSE).

## Acknowledgments

- Thanks to the Java and Swing communities for the resources and support in developing this application.

---

This README serves as a comprehensive guide to understanding, installing, and contributing to the Secure Login Application. For further inquiries, feel free to contact the author.
