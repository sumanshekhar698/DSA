package com.lpu.java.basics;

public class Conditionals {

	public static void main(String[] args) {

		int x = 40;

		// if else if else ladder
		if (x % 2 == 0) {// condition should evaluate to a boolean
			System.out.println("Even");
		} else if (x > 0) {
			System.out.println("Positive");

		} else if (x < 0) {
			System.out.println("Negative");

		} else {
			System.out.println("End");
		}

		if (x % 2 == 0) {// condition should evaluate to a boolean
			System.out.println("Even");
		}

		if (x > 0) {
			System.out.println("Positive");

		}
		if (x < 0) {
			System.out.println("Negative");

		} else {
			System.out.println("End");
		}

		
		
//		&&			all of them
//		||			any one of them
		
		if ((x % 2 == 0) && (x > 0)) {// condition should evaluate to a boolean
			System.out.println("Even & Positive");
		}

	}

}
