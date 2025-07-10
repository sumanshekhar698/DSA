package com.lpu.java.oops.intro;


public class Car {

//	instanceVariables  instance = object
	String color;// null
	int weight;// 0
	float mielage;// 0.0
	int topSpeedInKmph;// 0
	int safetyRatings;// 0

	void start() {
		System.out.println("Starting the car");

	}
	
	
	void accelerate() {
		System.out.println("Accelerating the car");
	}

	void stop() {
		System.out.println("Stopping the car");
	}

	String details() {
		return "Car [color=" + color + ", weight=" + weight + ", mielage=" + mielage + ", topSpeedInKmph="
				+ topSpeedInKmph + ", safetyRatings=" + safetyRatings + "]";
	}

}
