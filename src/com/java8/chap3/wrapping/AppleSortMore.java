package com.java8.chap3.wrapping;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import com.java8.chap2.ex1.Apple;
import static java.util.Comparator.comparing;

public class AppleSortMore {

	public static void main(String[] args) {
		List<Apple> inventory = getListOfApples();
		
		inventory.sort(comparing(Apple::getColor).reversed());
		printDetails(inventory);
		
		inventory.sort(comparing(Apple::getColor).reversed().thenComparing(Apple::getWeight));
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
	
	private static void printDetails(List<Apple> inventory) {
		for(Apple a : inventory){
			System.out.println(a.getColor());
		}
	}

}
