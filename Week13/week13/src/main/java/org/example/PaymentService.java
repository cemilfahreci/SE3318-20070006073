package org.example;

/**
 * Handles payment processing and validation
 * Implements secure payment processing with comprehensive validation
 */
public class PaymentService {
    private static final String CURRENCY_PATTERN = "^[A-Z]{3}$";
    private static final double MAX_AMOUNT = 1000000.00;

    /**
     * Processes a payment with the given card number, amount, and currency
     * @param cardNumber The credit card number
     * @param amount The payment amount
     * @param currency The currency code (e.g., USD)
     * @throws IllegalArgumentException if any validation fails
     */
    public void processPayment(String cardNumber, double amount, String currency) {
        // Input validation
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null or empty");
        }
        if (currency == null || currency.trim().isEmpty()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }

        // Card number format validation
        if (!cardNumber.matches("^\\d{16}$")) {
            throw new IllegalArgumentException("Card number must be exactly 16 digits");
        }

        // Luhn algorithm validation
        if (!isValidLuhn(cardNumber)) {
            throw new IllegalArgumentException("Invalid card number (failed Luhn check)");
        }

        // Currency format validation
        if (!currency.matches(CURRENCY_PATTERN)) {
            throw new IllegalArgumentException("Currency must be a 3-letter code (e.g., USD)");
        }

        // Amount validation
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException("Amount exceeds maximum limit of " + MAX_AMOUNT);
        }

        // Process payment based on card type
        if (cardNumber.startsWith("4")) {
            if (currency.equals("USD")) {
                System.out.println("Processing Visa USD payment");
            } else {
                System.out.println("Visa payment in other currency");
            }
        } else {
            System.out.println("Non-Visa card detected");
        }
    }

    /**
     * Validates a card number using the Luhn algorithm
     * @param cardNumber The card number to validate
     * @return true if the card number is valid
     */
    private boolean isValidLuhn(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        
        return (sum % 10 == 0);
    }
}
