package com.lpu.java.dsa.maths.general;

import java.util.Scanner;

public class CollatzConjecture {

    public static void collatzSequence(long n) {
        int steps = 0;
        System.out.print("Sequence: " + n);

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            System.out.print(" → " + n);
            steps++;
        }

        System.out.println("\nTotal steps: " + steps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        long n = sc.nextLong();

        if (n <= 0) {
            System.out.println("Please enter a positive number greater than 0.");
        } else {
            collatzSequence(n);
        }

        sc.close();
    }
}
