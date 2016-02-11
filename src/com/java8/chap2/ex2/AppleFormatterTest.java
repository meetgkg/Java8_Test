package com.java8.chap2.ex2;

import java.util.ArrayList;
import java.util.List;

import com.java8.chap2.ex1.Apple;

public class AppleFormatterTest {

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
		
		prettyPrintApple(inventory, new AppleSimpleFormatter());

	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}

}
