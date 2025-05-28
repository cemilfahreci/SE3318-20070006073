package org.example;

import java.util.regex.Pattern;

/**
 * Validates user information
 * Implements comprehensive validation checks for user details
 */
public class UserValidator {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    /**
     * Validates user information including name, age, and email
     * @param name User's full name
     * @param age User's age
     * @param email User's email address
     * @return true if all validations pass
     * @throws IllegalArgumentException if any validation fails
     */
    public boolean validateUser(String name, int age, String email) {
        // Name validation
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name is too short");
        }
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException("Name can only contain letters and spaces");
        }

        // Age validation
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }

        // Email validation
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!emailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return true;
    }
}