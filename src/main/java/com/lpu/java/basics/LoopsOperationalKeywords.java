package com.lpu.java.basics;

public class LoopsOperationalKeywords {

	public static void main(String[] args) {

//		for (int i = 0; i < 10; i++) {
//
//			System.out.println(i);
//			if (i > 5) {
//				break;
//			}
//
//		}

		first: for (int i = 0; i < 10; i++) {

			if (i == 5) {
				continue first;
			}

			System.out.println(i);

		}

	}

}
