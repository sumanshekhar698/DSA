package com.lpu.java.oops.intro;

public class Main {

	public static void main(String[] args) {

		int x;
//		System.out.println(x);
		
		Car c1 = new Car();//1 object
		System.out.println(c1.weight);
		System.out.println(c1.details());
		c1.safetyRatings = 4;
		System.out.println(c1.details());
		System.out.println(c1);//7960847b hashcode
		System.out.println(c1.hashCode());

		
		Car c2 = new Car();//2 object
		System.out.println(c2.safetyRatings);
		System.out.println(c2.details());
		c2.safetyRatings = 2;
		System.out.println(c1.details());
		System.out.println(c2);//6a6824be hashcode hexadecimal number
		System.out.println(c2.hashCode());
		
		
		Car c3 = null;
		System.out.println(c3);
		
		
		c3 = c2;
		
		c1 = null;
		
		c2 = null;
	}

}
