package com.java8.streams.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTraversableTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Gaurav","Amit","Ankit","Anamika");
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);
		stream.forEach(System.out::println);
	}

}
