package com.java8.streams.chap4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class DishOperations {

	public static void main(String[] args) {
		
		List<Dish> menu = DishMaker.makeDish();
		
		sortUsingJava8(menu);

	}
	
	private static void sortUsingJava8(List<Dish> menu) {
		List<String> list = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.map(Dish::getName)
				.limit(3)
				.collect(toList());
		
		System.out.println(list);
	}

}
