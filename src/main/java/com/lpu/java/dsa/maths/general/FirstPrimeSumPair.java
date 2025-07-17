package com.lpu.java.dsa.maths.general;

import java.util.*;

public class FirstPrimeSumPair {


    public static void main(String[] args) {
        int n = 34;
        printFirstPrimePair(n);
    }

    // Sieve of Eratosthenes O(n * log(log n))
    public static boolean[] sieve(int n) {



/*        boolean[] primes = new boolean[right + 1];

        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        long sqrt = (long) Math.sqrt(right);
        for (int i = 2; i <= sqrt; i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i * i; j <= right; j += i) {
                primes[j] = false;
            }
        }*/

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);//ASSUMPTION

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {// we can start with 2*i
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }


    /*
    * Question	Answer
        Does every number have a prime pair?	❌ No, only even ≥ 4 always (if Goldbach is true).
        Do odd numbers have prime pairs?	❌ Not always. Only if n - 2 is prime.
        Can a number have multiple prime pairs?	✅ Yes, many numbers do.
    * */
    // Print first prime pair (p1, p2) such that p1 + p2 = n
    public static void printFirstPrimePair(int n) {
        if (n < 4) {
            System.out.println("No such pair possible.");
            return;
        }

        boolean[] isPrime = sieve(n);

        for (int i = 2; i <= n / 2; i++) {
            int j = n - i;
            if (isPrime[i] && isPrime[j]) {
                System.out.println(n + " = " + i + " + " + j);
                return;
            }
        }

        System.out.println("No prime pair found for " + n);
    }


}
