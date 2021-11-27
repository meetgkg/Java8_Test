package com.java8.chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class AppleFilter {
	
	/*
	 * Added Some comments
	 */
	
	public static void main(String[] args) {
		Apple apple1 = new Apple("apple1", "green");
		Apple apple2 = new Apple("apple2", "orange");
		Apple apple3 = new Apple("apple3", "red");
		Apple apple4 = new Apple("apple4", "green");
		Apple apple5 = new Apple("apple5", "yellow");
		
		List<Apple> inventory = new ArrayList<Apple>();
		inventory.add(apple1);
		inventory.add(apple2);
		inventory.add(apple3);
		inventory.add(apple4);
		inventory.add(apple5);
		
		List<Apple> filteredApples = filterApple(inventory, Apple::isAppleGreen);
		System.out.println(filteredApples.toString());
		
		
		List<Apple> filteredApples2 = filterApple(inventory, (Apple a) -> "green".equals(a.getColor()) );
		System.out.println(filteredApples2.toString());
		
		Stream<Apple> filteredApples3 = inventory.stream().filter( (Apple a) -> a.getColor().equalsIgnoreCase("green") );
		System.out.println(filteredApples3.collect(toList()));
		
		List<Apple> greenApples = inventory.stream().filter( (Apple a) -> "green".equals(a.getColor()) ).collect(toList());
		System.out.println(greenApples);
		
		List<Apple> greenParallelApples = inventory.parallelStream().filter( (Apple a) -> "green".equals(a.getColor()) ).collect(toList());
		System.out.println(greenParallelApples);
	}
	
	static List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> p){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : appleList){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}

}
