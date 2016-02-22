package com.java8.streams.chap5.ex1;

import java.util.List;

import com.java8.streams.chap4.Dish;
import com.java8.streams.chap4.DishMaker;

public class DishOperations {

	public static void main(String[] args) {
		
		List<Dish> menu = DishMaker.makeDish();
		
		sortUsingJava8(menu);

	}
	
	private static void sortUsingJava8(List<Dish> menu) {
		int totalCalories = menu.stream()
				.map(Dish::getCalories)
				.reduce(0, Integer::sum);
		
		System.out.println(totalCalories);
	}

}
