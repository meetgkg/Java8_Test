package com.java8.streams.chap4.ex1;

public class Dish {
	
	public Dish(String name, int calorie) {
		super();
		this.name = name;
		this.calorie = calorie;
	}
	
	public Dish() {
	}

	private int calorie = 0;

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
