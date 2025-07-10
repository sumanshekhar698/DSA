package com.lpu.java.basics;

public class OperatorsInJava {

	public static void main(String[] args) {

//		Assignment operator
		int x = 9;

//		increment and decrement operators
//		x++;//post increment
		System.out.println(x++);
		++x;// pre increment
		System.out.println(x);

		x = 10;
		System.out.println(--x);
//		--x;//post decrement
		x--;// pre decrement
		System.out.println(x);

//		Arithmetic Operators + - / * %
		x = 8 + 9;
		System.out.println(10 % 3);

//		Shorthand Operators
		x = 100;

//		x = x + 5;
		x += 5;
		x *= 10;
		

	}

}
