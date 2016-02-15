package com.java8.chap3.chap3book;

public class Apple {
	
	private String color;
	
	private int weight;
	
	public Apple() {
	}
	
	public Apple(String color, int weight) {
		this.color = color;
		this.weight = weight;
	}

	public Apple(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public static boolean isAppleGreen(Apple apple){
		return "green".equalsIgnoreCase(apple.getColor());
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}

}
