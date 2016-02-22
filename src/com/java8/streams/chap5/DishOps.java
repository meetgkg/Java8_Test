package com.java8.streams.chap5;

import java.util.List;

import com.java8.streams.chap4.Dish;
import com.java8.streams.chap4.DishMaker;
import static java.util.stream.Collectors.toList;

public class DishOps {
	
public static void main(String[] args) {
		
		List<Dish> menu = DishMaker.makeDish();
		
		List<Integer> dishNames = menu.stream()
				.map(Dish::getName)
				.map(String::length)
				.collect(toList());
		System.out.println(dishNames.toString());
	}
}
