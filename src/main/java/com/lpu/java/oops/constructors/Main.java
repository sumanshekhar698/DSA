package com.lpu.java.oops.constructors;

public class Main {

	public static void main(String[] args) {

//		Truck t1 = new Truck();// 1 object
//		System.out.println(t1.details());
		
		
		Truck t2 = new Truck("Brown",2000, 10.4f,100,3);
		System.out.println(t2.details());
		System.out.println(t2);
		
		Truck t3 = t2.returnMe();
		System.out.println(t3);
		
	}

}
