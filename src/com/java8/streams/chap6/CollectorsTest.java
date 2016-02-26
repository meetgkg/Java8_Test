package com.java8.streams.chap6;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8.streams.chap4.Dish;
import com.java8.streams.chap4.DishMaker;

public class CollectorsTest {

	public static void main(String[] args) {
		
		List<Dish> menu = DishMaker.makeDish();
		
		long numOfDishes = menu.stream().collect(Collectors.counting());
		System.out.println("Total Number of Dishes : "+numOfDishes);
		
		Comparator<Dish> dishComparatorOnCalories = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> maxCaloriesDish = menu.stream().collect(Collectors.maxBy(dishComparatorOnCalories));
		System.out.println("Max Calorie Dish : "+maxCaloriesDish.get());
		
		Optional<Dish> minCaloriesDish = menu.stream().collect(Collectors.minBy(dishComparatorOnCalories));
		System.out.println("Min Calorie Dish : "+minCaloriesDish.get());
		
		int totalMenuCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println("Total Calorie in Dish : "+totalMenuCalories);
		
		double avgCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
		System.out.println("Avg Calorie in Dish : "+avgCalories);
		
		IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println("Statistics : Avg : "+menuStatistics.getAverage()
													+ " Count : " + menuStatistics.getCount()
													+ " Max : " + menuStatistics.getMax()
													+ " Min : " + menuStatistics.getMin()
													+ " Total : " + menuStatistics.getSum());
		
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println("Short Menu : "+shortMenu);
		
		//String shortMenu2 = menu.stream().collect(Collectors.joining());
		
		int totalCal = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j) );
		System.out.println("Total Cal using reducing 1 : "+totalCal);
		
		Optional<Dish> totalCal2 = menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2) );
		System.out.println("Total Cal using reducing 2 : "+totalCal2.get());
		
		int totalCal3 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum) );
		System.out.println("Total Cal using reducing 3 : "+totalCal3);
		
		callQuiz1(menu);
		
	}

	private static void callQuiz1(List<Dish> menu) {
		
		//Original Operation
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
		System.out.println(shortMenu);
		
		//Op # 1
		String shortMenu1 = menu.stream().map(Dish::getName).collect( Collectors.reducing ( ( s1, s2) -> s1+s2 ) ).get();
		System.out.println(shortMenu1);
		
		//Op # 2
		//String shortMenu2 = menu.stream().collect( Collectors.reducing( (d1, d2) -> d1.getName() + d2.getName() ) ).get();
		Dish shortMenu2 = menu.stream().collect( Collectors.reducing( (d1, d2) -> d1  ) ).get();//
		System.out.println(shortMenu2);
		
		//Op # 3
		String shortMenu3 = menu.stream().collect( Collectors.reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
		System.out.println(shortMenu3);
		
	}

}
