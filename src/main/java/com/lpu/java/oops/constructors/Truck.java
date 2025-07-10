package com.lpu.java.oops.constructors;

public class Truck {

//	instanceVariables  instance = object
	String color;// null
	int weight;// 0
	float mielage;// 0.0
	int topSpeedInKmph;// 0
	int safetyRatings;// 0

//	Truck()  ==> Constructor re used to initialize object
//	It has the same name as of class
//	It is called automatically once the object is made
//	JVM adds a default constructor if you haven't declared your own

	
//	Truck Constructor is Over Loaded and it follows all the rules of Method Overloading
	Truck() {// Parameter less Constructor
		System.out.println("Truck  Parameterless called");
	}

	Truck(String color, int weight) {
		this();
		System.out.println("Truck parametrized 2 called");

	}

	// Parameterized Constructor
	Truck(String color, int weight, float mielage, int topSpeedInKmph, int safetyRatings) {
		this(color, weight);// chaining should be the 1st statement

		System.out.println("Truck parametrized 1 called");

//		this is a keyword in java, it points to the current object
//		Shadow problem

		System.out.println(this);
		this.color = color;
		this.weight = weight;
		this.mielage = mielage;
		this.topSpeedInKmph = topSpeedInKmph;
		this.safetyRatings = safetyRatings;
	}
	
	Truck returnMe(){
		return this;
	}

	void start() {
		System.out.println("Starting the Truck");

	}

	void accelerate() {
		System.out.println("Accelerating the Truck");
	}

	void stop() {
		System.out.println("Stopping the Truck");
	}

	String details() {
		return "Truck [color=" + color + ", weight=" + weight + ", mielage=" + mielage + ", topSpeedInKmph="
				+ topSpeedInKmph + ", safetyRatings=" + safetyRatings + "]";
	}

}
