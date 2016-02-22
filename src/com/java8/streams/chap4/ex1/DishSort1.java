package com.java8.streams.chap4.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class DishSort1 {
	
	//Task is, take all dishes in menu and sort based on calories for 
	//all dishes for which calory is less thn 400

	public static void main(String[] args) {
		List<Dish> menu = getMenu();
		
		List<Dish> finalMenu1 = sortUsingJava7(menu);
		printMenuDetails(finalMenu1);
		
		List<Dish> finalMenu2 = sortUsingJava8(menu);
		printMenuDetails(finalMenu2);
		
		List<Dish> finalMenu3 = sortUsingJava8Parallel(menu);
		printMenuDetails(finalMenu3);
	}

	private static List<Dish> sortUsingJava8(List<Dish> menu) {
		List<Dish> list = menu.stream()
				.filter(d -> d.getCalorie() <= 400)
				.sorted(comparing(Dish::getCalorie))
				.collect(toList());
		
		return list;
	}
	
	private static List<Dish> sortUsingJava8Parallel(List<Dish> menu) {
		List<Dish> list = menu.parallelStream()
				.filter(d -> d.getCalorie() <= 400)
				.sorted(comparing(Dish::getCalorie))
				.collect(toList());
		
		return list;
	}

	private static List<Dish> sortUsingJava7(List<Dish> menu) {
		
		List<Dish> lowCalorieDish = new ArrayList<Dish>();
		for(Dish d : menu){
			if(d.getCalorie() <= 400)
				lowCalorieDish.add(d);
		}
		
		Collections.sort(lowCalorieDish, new Comparator<Dish>() {

			@Override
			public int compare(Dish o1, Dish o2) {
				return o2.getCalorie() - o1.getCalorie();
			}
		});
		
		return lowCalorieDish;
		
	}

	private static List<Dish> getMenu() {
		List<Dish> menu = new ArrayList<Dish>();
		Dish d1 = new Dish("Samosa", 200);
		Dish d2 = new Dish("Jalebi", 300);
		Dish d3 = new Dish("Gulabjamun", 400);
		Dish d4 = new Dish("Chhola Bhature", 500);
		menu.add(d1);menu.add(d2);menu.add(d3);menu.add(d4);
		return menu;
	}
	
	public static  void printMenuDetails(List<Dish> menu){
		for(Dish d : menu){
			System.out.println("Dish Name : "+d.getName()+" Dish Calories : " +d.getCalorie());
		}
	}

}
