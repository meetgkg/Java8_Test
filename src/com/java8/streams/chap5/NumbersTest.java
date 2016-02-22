package com.java8.streams.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NumbersTest {

	public static void main(String[] args) {
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		add(someNumbers);
		multiplication(someNumbers);
		add2(someNumbers);
		max(someNumbers);
	}

	private static void add(List<Integer> someNumbers) {
		int sum = someNumbers.stream().reduce(0, (a,b) -> a + b);
		System.out.println("Addition : "+sum);
		
	}
	
	private static void add2(List<Integer> someNumbers) {
		int sum = someNumbers.stream().reduce(0, Integer::sum);
		System.out.println("Addition2 : "+sum);
		
	}
	
	private static void multiplication(List<Integer> someNumbers) {
		int multi = someNumbers.stream().reduce(1, (a,b) -> a * b);
		System.out.println("Multiplication : "+multi);
		
	}
	
	private static void max(List<Integer> someNumbers) {
		Optional<Integer> max = someNumbers.stream().reduce(Integer::max);
		System.out.println("Max : "+max.get());
		
		Optional<Integer> max2 = someNumbers.stream().reduce((x, y) -> x<y?y:x);
		System.out.println("Max : "+max2.get());
		
	}

}
