package com.java8.chap3.wrapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.java8.chap2.ex1.Apple;

public class AppleSort {

	public static void main(String[] args) {
		List<Apple> inventory = getListOfApples();
		
		//First Approach - Create a static Comparator impl and pass it
		//firstSortMethod(inventory);
		
		//Second Approach - Anonymous fn
		//secondSortMethod(inventory);
		
		//Third Approach using lambda
		//thirdSortMethod(inventory);
		
		//Fourth Approach - little modification to lambda
		//fourthSortMethod(inventory);
		
		//Fifth Approach - Code Readability
		//fifthSortMethod(inventory);
		
		//Sixth Solution - Method Reference
		sixthSortMethod(inventory);
	}

	private static void sixthSortMethod(List<Apple> inventory) {
		inventory.sort(Comparator.comparing(Apple::getColor));
		printDetails(inventory);
	}

	private static void fifthSortMethod(List<Apple> inventory) {
		Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getColor());
		inventory.sort(c);
		printDetails(inventory);
	}

	private static void fourthSortMethod(List<Apple> inventory) {
		inventory.sort( (a1, a2) -> a1.getColor().compareTo(a2.getColor()) );
		printDetails(inventory);
	}

	private static void thirdSortMethod(List<Apple> inventory) {
		inventory.sort( (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor()) );
		printDetails(inventory);
	}

	private static void secondSortMethod(List<Apple> inventory) {
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getColor().compareTo(o2.getColor());
			}
			
		});
		printDetails(inventory);
	}

	private static void firstSortMethod(List<Apple> inventory) {
		inventory.sort(new AppleComparator());
		printDetails(inventory);
	}

	private static List<Apple> getListOfApples() {
		Apple apple1 = new Apple("green",200);
		Apple apple2 = new Apple("orange",100);
		Apple apple3 = new Apple("red",155);
		Apple apple4 = new Apple("black",120);
		Apple apple5 = new Apple("yellow",180);
		
		List<Apple> inventory = new ArrayList<Apple>();
		inventory.add(apple1);
		inventory.add(apple2);
		inventory.add(apple3);
		inventory.add(apple4);
		inventory.add(apple5);
		
		return inventory;
	}
	
	//Static impl of Comparator
	static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
        	return a1.getColor().compareTo(a2.getColor());
        }
    }
	
	private static void printDetails(List<Apple> inventory) {
		for(Apple a : inventory){
			System.out.println(a.getColor());
		}
	}

}
