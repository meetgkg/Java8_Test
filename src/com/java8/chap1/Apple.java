package com.java8.chap1;

public class Apple {
	
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Apple(String color) {
		this.color = color;
	}
	
	public static boolean isAppleGreen(Apple apple){
		return "green".equalsIgnoreCase(apple.getColor());
	}

}
