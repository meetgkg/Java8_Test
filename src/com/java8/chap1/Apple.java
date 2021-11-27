package com.java8.chap1;

public class Apple {
	
	private String appleName;
	private String color;

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Apple(String color) {
		this.color = color;
	}
	
	public Apple(String appleName, String color) {
		this.appleName = appleName;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Apple [appleName=" + appleName + ", color=" + color + "]";
	}

	public static boolean isAppleGreen(Apple apple){
		return "green".equalsIgnoreCase(apple.getColor());
	}

}
