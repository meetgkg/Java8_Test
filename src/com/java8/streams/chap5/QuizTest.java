package com.java8.streams.chap5;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class QuizTest {

	public static void main(String[] args) {
		squareMap();
		quiz2();
		quiz3();
	}
	
	public static void squareMap(){
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Integer> square = data.stream()
								.map(n -> n*n)
								.collect(toList());
		
		System.out.println(square);
	}
	
	public static void quiz2(){
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream()
				.flatMap(i -> numbers2.stream()
						.map(j -> new int[] { i, j }))
							.collect(toList());
		System.out.println(pairs.toString());
	}
	
	public static void quiz3(){
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream()
								.flatMap(i -> numbers2.stream()
										.filter(j -> (i + j) % 3 == 0)
										.map(j -> new int[] { i, j }))
										.collect(toList());
		System.out.println(pairs);
	}
}
