package com.java8.streams.chap6;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8.streams.chap4.Dish;
import com.java8.streams.chap4.DishMaker;

public class GroupingTest {

	public static void main(String[] args) {
		
		List<Dish> menu = DishMaker.makeDish();
		
		groupingOnDishType(menu);
		
		groupingBasedOnCalories(menu);
		
		multiLevelGrouping(menu);
		
		groupByCount(menu);
		
		groupByMaxValue(menu);
		
		groupByMaxValueNoOptional(menu);
		
		groupSum(menu);
		
		groupByDishType(menu);
	}


	private static void groupByDishType(List<Dish> menu) {
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
					menu.stream().collect(
								groupingBy(Dish::getType, mapping(
											dish -> { 	if (dish.getCalories() <= 400) return CaloricLevel.DIET;
														else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
														else return CaloricLevel.FAT; },
											toSet() 
									)));
		System.out.println(caloricLevelsByType);
		
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType2 =
				menu.stream().collect(
				groupingBy(Dish::getType, mapping(
				dish -> { 	if (dish.getCalories() <= 400) return CaloricLevel.DIET;
							else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
							else return CaloricLevel.FAT; },
				toCollection(HashSet::new) )));
		
		System.out.println(caloricLevelsByType2);
	}


	private static void groupSum(List<Dish> menu) {
		Map<Dish.Type, Integer> totalCaloriesByType =
				menu.stream().collect(groupingBy(Dish::getType,
				summingInt(Dish::getCalories)));
		System.out.println(totalCaloriesByType);
	}
	
	
	private static void groupByMaxValueNoOptional(List<Dish> menu) {
		Map<Dish.Type, Dish> mostCaloricByType =
				menu.stream()
				.collect(groupingBy(Dish::getType,
				Collectors.collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricByType);
	}

	private static void groupByMaxValue(List<Dish> menu) {
		Map<Dish.Type, Optional<Dish>> mostCaloricByType =
				menu.stream()
				.collect(groupingBy(Dish::getType,
				maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(mostCaloricByType);
	}

	private static void groupByCount(List<Dish> menu) {
		Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(typesCount);
	}

	private static void groupingOnDishType(List<Dish> menu) {
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);
	}

	private static void groupingBasedOnCalories(List<Dish> menu) {
		Map<CaloricLevel, List<Dish>> mapAsPerDietPlan = menu.stream().collect(groupingBy(
				dish -> {
					if (dish.getCalories() <= 400) return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));
		System.out.println(mapAsPerDietPlan);
	}

	private static void multiLevelGrouping(List<Dish> menu) {
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> mapAsPerDietPlan2 = menu.stream().collect(
				groupingBy(Dish::getType, 
						groupingBy(dish -> {
							System.out.println("Inner");
							if (dish.getCalories() <= 400) return CaloricLevel.DIET;
							else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
							else return CaloricLevel.FAT;
						})
					)
				);
		System.out.println(mapAsPerDietPlan2);
	}

	private static void printMenuGroupedDetailsUsingIterator(Map<Dish.Type, List<Dish>> dishesByType) {
		Iterator<Map.Entry<Dish.Type, List<Dish>>> it = dishesByType.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Dish.Type, List<Dish>> pair = (Map.Entry<Dish.Type, List<Dish>>)it.next();
			System.out.println(pair.getKey());
			System.out.println(pair.getValue());
		}
	}
	
	public enum CaloricLevel { DIET, NORMAL, FAT }
	
}
