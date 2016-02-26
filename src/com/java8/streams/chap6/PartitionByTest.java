package com.java8.streams.chap6;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.counting;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import com.java8.streams.chap4.Dish;
import com.java8.streams.chap4.DishMaker;

public class PartitionByTest {

	public static void main(String[] args) {
		
		List<Dish> menu = DishMaker.makeDish();
		
		partitionBy(menu);
		
		partitionByAndGroupBy(menu);
		
		partitionByMaxGrpBy(menu);
		
		quiz1(menu);
		
		quiz3(menu);
		
		Map<Boolean, List<Integer>> data = partitionPrimes(31);
		System.out.println(data);
		
	}
	
	public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
				.collect(partitioningBy(candidate -> isPrime(candidate)));
	}
	
	public static boolean isPrime(int candidate){
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
	}

	private static void quiz3(List<Dish> menu) {
		Map<Boolean, Long> list = menu.stream().collect(partitioningBy(Dish::isVegetarian,	counting()));
		System.out.println(list);
		
	}

	private static void quiz1(List<Dish> menu) {
		Map<Boolean, Map<Boolean, List<Dish>>> list = menu.stream().collect(partitioningBy(Dish::isVegetarian,
				partitioningBy(d -> d.getCalories() > 500)));
		System.out.println(list);
		
	}

	private static void partitionByMaxGrpBy(List<Dish> menu) {
		Map<Boolean, Dish> list = menu.stream().collect(partitioningBy(Dish::isVegetarian, 
				collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(list);
	}

	private static void partitionByAndGroupBy(List<Dish> menu) {
		Map<Boolean, Map<Dish.Type, List<Dish>>> partitiondMenu = menu.stream()
							.collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
		System.out.println(partitiondMenu);
		
	}

	private static void partitionBy(List<Dish> menu) {
		Map<Boolean, List<Dish>> partitiondMenu = menu.stream()
													.collect(partitioningBy(Dish::isVegetarian));
		System.out.println(partitiondMenu);
		
		List<Dish> vegetarianDishes = partitiondMenu.get(true);
		System.out.println(vegetarianDishes);
		
		List<Dish> vegetarianDishes2 =
				menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println(vegetarianDishes2);
		
		List<Dish> nonVegetarianDishes = partitiondMenu.get(false);
		System.out.println(nonVegetarianDishes);
	}

}

