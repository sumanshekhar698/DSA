package com.lpu.java.dsa.arrays.two_d;

public class MatrixMultiplication {

    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length;
        int c1 = mat1[0].length;
        int r2 = mat2.length;
        int c2 = mat2[0].length;

        // Check if multiplication is possible
        if (c1 != r2) {
            return new int[0][0]; // Return empty matrix
        }

        int[][] result = new int[r1][c2];

        // Multiply matrices
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {//

                for (int k = 0; k < c1; k++) {//core logic
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }

            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 4, 2},
            {7, 5, 3}
        };

        int[][] mat2 = {
            {3, 6, 5},
            {4, 2, 3},
            {2, 1, 3}
        };

        int[][] result = multiplyMatrices(mat1, mat2);

        // Print the result
        if (result.length == 0) {
            System.out.println("Matrix multiplication not possible.");
        } else {
            for (int[] row : result) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}
