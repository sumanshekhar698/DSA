package com.lpu.java.oops.strings.immutable;

public class StringIntro {

	public static void main(String[] args) {

//		String is simply a collection or a group of characters

		/*
		 * - Strings are Objects in Java - Immutable Strings - Mutable Strings
		 */

//		Immutable Strings

		String s1 = new String("Kalki");// Heap

		String s2 = "Kalki";// CP
		String s3 = "Kalki";// CP
		String s4 = "Arjun";
		String s5 = "kaLkI";

		System.out.println(s1);
		System.out.println(s2);

		if (s2 == s3) {// == it will compare the Address of the Object
			System.out.println("Equal");

		} else {
			System.out.println("UnEqual");

		}

		if (s4 == s3) {
			System.out.println("Equal");

		} else {
			System.out.println("UnEqual");

		}

		if (s1 == s2) {
			System.out.println("Equal");// 1

		} else {
			System.out.println("UnEqual");

		}

		if (s1.equals(s2)) {//Values comparison
			System.out.println("Equal");// 1

		} else {
			System.out.println("UnEqual");
		}
		
		if (s2.equalsIgnoreCase(s5)) {//Values comparison Case Insensitive
			System.out.println("Equal");// 1

		} else {
			System.out.println("UnEqual");
		}

	}

}
