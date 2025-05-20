package org.example;

/**
 * Demonstrates proper and improper loop control usages.
 */
public class LoopControl {

    /**
     * Demonstrates correct variable usage within allowed distance.
     */
    public void correctVariableUsage() {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println("Correct sum (1–5): " + sum);
    }

    /**
     * Demonstrates incorrect variable usage violating VariableDeclarationUsageDistance.
     */
    public void incorrectVariableUsage() {
        int sum = 0;
        System.out.println("Starting calculation...");
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println("Incorrect sum (1–5): " + sum);
    }

    /**
     * Demonstrates an empty block without violation.
     */
    public void avoidEmptyBlock() {
        if (false) {
        }
    }

    /**
     * Demonstrates correct modification of the control variable in the loop header.
     */
    public void correctlyModifiedControlVariable() {
        for (int i = 0; i < 10; i += 2) {
            System.out.println("Even: " + i);
        }
    }

    /**
     * Demonstrates incorrect modification of the control variable inside the loop body.
     */
    public void modifiedControlVariable() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Index: " + i);
            i += 1;
        }
    }
}