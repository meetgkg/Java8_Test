package com.java8.streams.chap5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java8.streams.chap4.Dish;
import com.java8.streams.chap4.DishMaker;

public class MatchTest {

	public static void main(String[] args) {
		List<Dish> dishList = DishMaker.makeDish();
		
		checkIfAnyVeg(dishList);
		checkAllMatch(dishList);
		
		findAny(dishList);

	}

	private static void findAny(List<Dish> dishList) {
		
		Optional<Dish> anyVegDish = dishList.stream()
				.filter(Dish::isVegetarian)
				.findAny();
		System.out.println(anyVegDish.toString());
		System.out.println(anyVegDish.isPresent());
		System.out.println(anyVegDish.get());
		
		List<Dish> dishList2 = new ArrayList<>();
		Optional<Dish> anyVegDish2 = dishList2.stream().filter(Dish::isVegetarian).findAny();
		System.out.println(anyVegDish2.isPresent());
		System.out.println(anyVegDish2.get());
		
		
	}

	private static void checkIfAnyVeg(List<Dish> dishList) {
		if(dishList.stream().anyMatch(Dish::isVegetarian))
			System.out.println("Vegetarian also Invited !!");
	}
	
	
	private static void checkAllMatch(List<Dish> dishList) {
		if(dishList.stream().allMatch(d -> d.getCalories() < 1000))
			System.out.println("Only low calorie dishes");
		
		boolean isHealthy = dishList.stream()
				.allMatch(d -> d.getCalories() < 1000);
		
		if(isHealthy){
			System.out.println("Healthy Menu");
		}else{
			System.out.println("Non healthy Menu");
		}
	}

}
