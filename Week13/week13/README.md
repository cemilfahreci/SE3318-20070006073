# E-Commerce Platform Code Quality Improvement

This project demonstrates the improvement of an e-commerce platform's backend code quality and safety. The original code had several issues with input validation, error handling, and defensive programming principles.

## Project Structure

The project consists of four main classes:

1. `App.java` - Entry point that simulates real-world scenarios
2. `OrderProcessor.java` - Handles order processing and validation
3. `UserValidator.java` - Validates user information
4. `PaymentService.java` - Processes payments with proper validation

## Improvements Made

### 1. Order Processing
- Added null checks for order ID and items list
- Implemented order ID format validation
- Added empty list checks
- Improved error handling with meaningful messages

### 2. User Validation
- Added comprehensive name validation
- Implemented age range checks
- Added email format validation
- Improved error handling with specific messages

### 3. Payment Handling
- Added card number format validation
- Implemented Luhn algorithm for card number verification
- Added currency format validation
- Added amount validation with maximum limit
- Improved error handling with specific messages

## Defensive Programming Principles Applied

1. **Input Validation**
   - Null checks
   - Empty string checks
   - Format validation
   - Range validation

2. **Error Handling**
   - Meaningful error messages
   - Proper exception handling
   - Graceful failure handling

3. **Code Structure**
   - Clear and structured conditionals
   - Logical grouping of validations
   - Comprehensive documentation

## How to Run

1. Ensure you have Java 21 and Maven installed
2. Clone the repository
3. Run `mvn clean install` to build the project
4. Run `mvn exec:java -Dexec.mainClass="org.example.App"` to execute the application

## Testing

The application includes test scenarios in the `App` class that demonstrate:
- Valid input handling
- Invalid input handling
- Error message generation
- Exception handling 