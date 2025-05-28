package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * Main application class that demonstrates the e-commerce platform functionality.
 * This class serves as the entry point for the application and includes test scenarios
 * for order processing, user validation, and payment handling.
 */
public class App {
    public static void main(String[] args) {
        // Run test scenarios
        testOrderProcessing();
        testUserValidation();
        testPaymentProcessing();
    }

    /**
     * Tests order processing functionality with valid and invalid inputs
     */
    private static void testOrderProcessing() {
        System.out.println("\nTesting Order Processing:");
        OrderProcessor processor = new OrderProcessor();
        
        try {
            // Valid order
            processor.processOrder("ABC123", Arrays.asList("item1", "item2"));
            
            // Invalid order ID
            processor.processOrder("123", Arrays.asList("item1"));
        } catch (IllegalArgumentException e) {
            System.out.println("Order Processing Error: " + e.getMessage());
        }
    }

    /**
     * Tests user validation functionality with valid and invalid inputs
     */
    private static void testUserValidation() {
        System.out.println("\nTesting User Validation:");
        UserValidator validator = new UserValidator();
        
        try {
            // Valid user
            validator.validateUser("John Doe", 25, "john.doe@example.com");
            
            // Invalid email
            validator.validateUser("Jane", 30, "invalid-email");
        } catch (IllegalArgumentException e) {
            System.out.println("User Validation Error: " + e.getMessage());
        }
    }

    /**
     * Tests payment processing functionality with valid and invalid inputs
     */
    private static void testPaymentProcessing() {
        System.out.println("\nTesting Payment Processing:");
        PaymentService paymentService = new PaymentService();
        
        try {
            // Valid payment
            paymentService.processPayment("4111111111111111", 250.00, "USD");
            
            // Invalid card number
            paymentService.processPayment("1234567890123456", 100.00, "USD");
        } catch (IllegalArgumentException e) {
            System.out.println("Payment Processing Error: " + e.getMessage());
        }
    }
} 