package com.java8.streams.chap4;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class InterateStreamTest {

	public static void main(String[] args) {
		List<Dish> menu = DishMaker.makeDish();
		
		List<String> listOfMenuItems = menu.stream()
				.map(Dish::getName)
				.collect(toList());
		System.out.println(listOfMenuItems.toString());
	}

}
