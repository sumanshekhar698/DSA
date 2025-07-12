package com.lpu.java.dsa.maths;

public class AvgOfTwo {


    public static void main(String[] args) {
        int l = Integer.MAX_VALUE; // 2147483646
        int r = Integer.MAX_VALUE - 10000;     // 2147473647

        // Unsafe average
        int wrongMid = (l + r) / 2;
        System.out.println(wrongMid);
    }

    int safeAvg(int l, int r) {
        return l + (r - l) / 2;
    }
}
