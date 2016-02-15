package com.java8.chap3.chap3book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {

	public static void main(String[] args) {
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		
		List<String> listOfStrings = new ArrayList<String>();
		listOfStrings.add("Gaurav");
		listOfStrings.add("");
		listOfStrings.add("Anamika");
		listOfStrings.add("Ankit");
		List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
		System.out.println(nonEmpty);
		
		;
		List<Integer> rangeList = filter(Arrays.asList(1,2,3,4,5,6), (Integer i) -> i > 4 );
		System.out.println(rangeList);
		
	}
	
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	
}
