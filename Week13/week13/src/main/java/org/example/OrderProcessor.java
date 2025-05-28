package org.example;

import java.util.List;

/**
 * Handles order processing and validation
 * Implements defensive programming principles to ensure robust order handling
 */
public class OrderProcessor {
    private static final String ORDER_ID_PATTERN = "^[A-Z0-9]{5,10}$";

    /**
     * Processes an order with the given order ID and items
     * @param orderId The unique identifier for the order
     * @param items List of items in the order
     * @throws IllegalArgumentException if orderId or items are invalid
     */
    public void processOrder(String orderId, List<String> items) {
        // Null checks
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
        if (items == null) {
            throw new IllegalArgumentException("Items list cannot be null");
        }

        // Order ID format validation
        if (!orderId.matches(ORDER_ID_PATTERN)) {
            throw new IllegalArgumentException("Order ID must be 5-10 characters long and contain only uppercase letters and numbers");
        }

        // Empty items list check
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Items list cannot be empty");
        }

        // Process order based on complexity
        if (orderId.length() > 5) {
            System.out.println("Processing complex order: " + orderId);
        } else {
            System.out.println("Processing order: " + orderId);
        }

        // Process each item
        for (String item : items) {
            if (item == null) {
                System.out.println("Skipping null item");
                continue;
            }
            if (item.trim().isEmpty()) {
                System.out.println("Skipping empty item");
                continue;
            }
            if (item.contains("item")) {
                System.out.println("Valid item: " + item);
            } else {
                System.out.println("Skipping unknown item");
            }
        }
    }
}