# Scalable Tax Calculation API

The Scalable Tax Calculation API is a service that handles user data and tax calculations. It provides endpoints for user registration, login, and tax calculations.

## Features

- **User Management**: Allows users to register and login to the system.
- **Tax Calculation**: Provides endpoints for calculating taxes based on user inputs.

## Technologies Used

- **Spring Boot**: Framework for building Java-based web applications.
- **MongoDB**: NoSQL database for storing user and tax data.
- **Gradle**: Build automation tool for managing dependencies and building projects.
- **Java 17**: Programming language used for backend development.

## Getting Started

1. **Clone the repository**:

    ```bash
    git clone https://github.com/ishubhamkr/scalable-tax-calculation-api.git
    ```

2. **Set up MongoDB**: Ensure you have MongoDB installed and running locally or configure the application to connect to your MongoDB instance.

3. **Configure the application**: Update the `application.properties` or `application.yaml` file with your MongoDB connection details.

4. **Build and run the application**:

    ```bash
    cd scalable-tax-calculation-api
    ./gradlew bootRun
    ```

5. **Test the API endpoints**: Use Postman or any other API testing tool to test the endpoints.

## API Endpoints

- **POST /scalableTaxCalculation/user/register**: Register a new user.
- **POST /scalableTaxCalculation/user/login**: Login an existing user.
- **POST /scalableTaxCalculation/tax/calculate**: Calculate taxes based on user inputs.

## Contributing

Contributions are welcome! If you find any issues or want to contribute to the project, feel free to submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
