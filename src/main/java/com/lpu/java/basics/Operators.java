package com.lpu.java.basics;

public class Operators {

    public static void main(String[] args) {


        // Assignment Operator
        int x = 10;

//        Unary Operators

//        INCREMENT
        x = 100;

        // POST INCREMENT
        System.out.println(x++);
        System.out.println(x);

        // PRE INCREMENT

        x = 100;
        System.out.println(++x);//101
        System.out.println(x);//101


        x = 100;
        System.out.println(x--);//100
        System.out.println(x);//99


        x = 100;
        System.out.println(--x);//99
        System.out.println(x);//99


        x = 100;
        int y = 50;

        x = ++x + y++ + --x + y + ++x + y - y-- - --x - x + --y;
        System.out.println(x);

        // 253, 253
        // 252, 252, 252, 252

//        Short Hand Operators

        x = 100;
        x = x + 10;

        x += 10;
        x *= 2;


//        Bit Wise Operators

        System.out.println(6 & 4);
        System.out.println(6 | 5);
        System.out.println(~5);
        System.out.println(7 ^ 7);
        System.out.println(6 << 2);

        System.out.println(8 >> 2);//SIGNED
        System.out.println(-8 >>> 2);//UNSIGNED


    }
}