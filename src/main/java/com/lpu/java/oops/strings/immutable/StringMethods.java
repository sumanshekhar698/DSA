package com.lpu.java.oops.strings.immutable;

public class StringMethods {

	public static void main(String[] args) {

		String str = "    HappyJourney  ";
//		String strTrimmed = str.trim();

		str = str.trim();
		System.out.println(str);// HappyJourney

		str = str.toLowerCase();
		System.out.println(str);//

		System.out.println(str.toUpperCase());

		System.out.println(str.length());
		System.out.println(str);

		System.out.println(str.charAt(str.length() - 1));// String index starts from 0

		String substring = str.substring(0, 5);
		System.out.println(substring);
		System.out.println(str.substring(5, str.length()));

		String str2 = str.concat("Everyone");//String concatination
		System.out.println(str2);

		str2 = str2 + " :) !!";
		System.out.println(str2);
		
		boolean contains = str2.contains("appy");
		System.out.println(contains);
		System.out.println(str2.lastIndexOf('y'));
		System.out.println(str2.indexOf('y'));
		
		

	}

}
