package org.example;

/**
 * Provides practical loop examples for array and matrix data.
 */
public class ExampleUsage {

    /**
     * Displays even numbers from 1 to 10.
     */
    public void displayEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * Sums elements of a sample integer array.
     * @return total sum
     */
    public int sumArray() {
        int[] nums = {1, 2, 3, 4, 5};
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }

    /**
     * Processes a 3x3 matrix: prints each element and calculates diagonal sum.
     */
    public void processMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int diagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
            diagonalSum += matrix[i][i];
        }
        System.out.println("Diagonal sum: " + diagonalSum);
    }
}