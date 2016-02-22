package com.java8.streams.chap5;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Test1 {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream()
				.map(String::length)
				.collect(toList());
		
		System.out.println(wordLengths);
	}

}
