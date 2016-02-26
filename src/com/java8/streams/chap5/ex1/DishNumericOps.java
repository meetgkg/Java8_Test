package com.java8.streams.chap5.ex1;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java8.streams.chap4.Dish;
import com.java8.streams.chap4.DishMaker;

public class DishNumericOps {

	public static void main(String[] args) {
		
		List<Dish> menu = DishMaker.makeDish();
		
		sortUsingSimpleStream(menu);
		sortUsingMaptoInt(menu);
		getMaxMaptoInt(menu);
		getOptionalMaxMaptoInt(menu);

	}
	
	private static void sortUsingSimpleStream(List<Dish> menu) {
		int totalCalories = menu.stream()
				.map(Dish::getCalories)
				.reduce(0, Integer::sum);
		
		System.out.println("sortUsingSimpleStream : "+totalCalories);
	}
	
	private static void sortUsingMaptoInt(List<Dish> menu) {
		IntStream intStream = menu.stream()
				.mapToInt(Dish::getCalories);
		//int totalCalories = intStream.sum();
		
		//System.out.println("sortUsingMaptoInt : "+totalCalories);
		
		Stream<Integer> stream = intStream.boxed();
		int totalCalories2 = stream.reduce(0, Integer::sum);
		System.out.println("sortUsingMaptoInt : "+totalCalories2);
	}
	
	private static void getMaxMaptoInt(List<Dish> menu) {
		OptionalInt totalCalories = menu.stream()
				.mapToInt(Dish::getCalories)
				.max();
		
		System.out.println("getMaxMaptoInt : "+totalCalories.getAsInt());
	}
	
	private static void getOptionalMaxMaptoInt(List<Dish> menu) {
		OptionalInt maxCalories = menu.stream()
				.mapToInt(Dish::getCalories)
				.max();
		
		System.out.println("getMaxMaptoInt : "+maxCalories.getAsInt());
	}

}
