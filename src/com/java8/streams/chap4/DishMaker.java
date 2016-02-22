package com.java8.streams.chap4;

import java.util.Arrays;
import java.util.List;

public class DishMaker {

	public static List<Dish> makeDish() {
		List<Dish> menu = Arrays.asList(
				new Dish("sandwich", false, 800, Dish.Type.MEAT),
				new Dish("mutton", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH));
		return menu;
	}

}
