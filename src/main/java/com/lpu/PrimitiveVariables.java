package com.lpu;


//R1: Class namees should exactly match the file name
// C1: The class name should be PascalCase
public class PrimitiveVariables {

    public static void main(String[] args) {
        System.out.println("Hello World");

        // integers
//      -  2^(n-1) to 2^(n-1)-1

        byte a = 10;// 1 byte :: 8 bits
        short b = 20;// 2 bytes :: 16 bits
        int c = 30;// 4 bytes :: 32 bits
        long d = 40L;// 8 bytes :: 64 bits

        long phNo = 9006567388L;

        int x = b;
//        b = x;


        System.out.println("x = " + x);

//      Floating numbers
        float valueOfPi = 3.14F;// 4 bytes
        double valueOfPi2 = 3.1415926535897932384626433832795;// 8 bytes

        float phFloat = phNo;
        System.out.println("phFloat = " + phFloat);//9.006567E9 = 9.006567 * 10^9 = 9006567000

//        Boolean
        boolean isRaining = true;
        isRaining = false;


//        Character
        char ch = 'a';
        char rupee = '₹';
        System.out.println((int) ch);
        System.out.println((int) rupee);


        int bin = 0B101011010;
        int num = 0567;//OCTAL NUMBER
        int hex = 0x1234;
        System.out.println(bin);
        System.out.println(num);
        System.out.println(hex);

        byte num1 = 4;

        num1 = -4;


    }


}

/*CASES
 *
 *
 * tomandjerry :: lowercase
 * TOMANDJERRY :: UPPERCASE
 * TomAndJerry
 *
 **/