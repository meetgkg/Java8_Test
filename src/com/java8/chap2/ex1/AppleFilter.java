package com.java8.chap2.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class AppleFilter {
	
	public static void main(String[] args) {
		Apple apple1 = new Apple("green",200);
		Apple apple2 = new Apple("orange",100);
		Apple apple3 = new Apple("red",155);
		Apple apple4 = new Apple("green",120);
		Apple apple5 = new Apple("yellow",180);
		
		List<Apple> inventory = new ArrayList<Apple>();
		inventory.add(apple1);
		inventory.add(apple2);
		inventory.add(apple3);
		inventory.add(apple4);
		inventory.add(apple5);
		
		List<Apple> finalAppleList1 = filterApple(inventory, new AppleGreenColorPredicate());
		System.out.println("Printing Details");
		printDetails(finalAppleList1);
		
		List<Apple> finalAppleList2 = filterApple(inventory, new AppleHeavyWeightPredicate());
		System.out.println("Printing Details");
		printDetails(finalAppleList2);
	}
	
	private static void printDetails(List<Apple> finalAppleList) {
		for(Apple apple : finalAppleList){
			System.out.println("Apple Details "+ "Color : "+ apple.getColor() + " ,Weight : "+ apple.getWeight());
		}
	}

	public static List<Apple> filterApple(List<Apple> appleList, ApplePredicate p){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : appleList){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}

}
