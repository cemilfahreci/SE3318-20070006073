package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        LoopControl loopControl = new LoopControl();
        ExampleUsage exampleUsage = new ExampleUsage();

        System.out.println("Demonstrating correct variable usage:");
        loopControl.correctVariableUsage();
        System.out.println("\nDemonstrating incorrect variable usage:");
        loopControl.incorrectVariableUsage();

        System.out.println("\nDemonstrating empty block usage (should handle without output):");
        loopControl.avoidEmptyBlock();

        System.out.println("\nDemonstrating correctly modified control variable:");
        loopControl.correctlyModifiedControlVariable();
        System.out.println("\nDemonstrating incorrectly modified control variable:");
        loopControl.modifiedControlVariable();

        System.out.println("\nDisplaying even numbers:");
        exampleUsage.displayEvenNumbers();

        System.out.println("\nSumming an array:");
        int sum = exampleUsage.sumArray();
        System.out.println("Total Sum: " + sum);

        System.out.println("\nProcessing a matrix:");
        exampleUsage.processMatrix();
    }
}