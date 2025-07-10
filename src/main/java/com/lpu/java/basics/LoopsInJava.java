package com.lpu.java.basics;

public class LoopsInJava {

	public static void main(String[] args) {

//		1 to 100

//		SCOPE

//		int x = 0;

//		for loop
		if (true) {
			int x = 9;
			System.out.println(x);
		}

		System.out.println();

//		System.out.println(x);

		for (int i = 1, j = 9; i <= 100; i++) { // initaition;condition;updation
			System.out.print(i + " ");
		}

		System.out.println();

		int i = 1;

		while (i <= 100) { // initaition;condition;updation
			System.out.print(i + " ");
			++i;
		}

		System.out.println();

		int j = 100;
		do {// it will execute atleast one time
			System.out.println("dooo");
		} while (j < 0);

	}

}
