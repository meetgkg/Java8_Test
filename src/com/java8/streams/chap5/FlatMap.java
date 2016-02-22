package com.java8.streams.chap5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class FlatMap {

	public static void main(String args[]) {
		getFlatMapUniqueChars();
	}

	public static void getFlatMapUniqueChars() {

		List<String> words = Arrays.asList("Hello", "World");
        List<String> wordLengths = words.stream()
        		.map(word -> word.split(""))
        		.flatMap(Arrays::stream)
        		.distinct()
        		.collect(toList());
        System.out.println(wordLengths);

	}
	
	public static void getSimpleMapUniqueChars() {

		List<String> words = Arrays.asList("Hello", "World");
		
		//Below will throw error that can nt convert List<Stream<String>> to List<String>
		//So we need to use flatMap instead of Map
        /*List<String> wordLengths = words.stream()
        		.map(word -> word.split(""))
        		.map(Arrays::stream)
        		.distinct()
        		.collect(toList());*/

	}
}