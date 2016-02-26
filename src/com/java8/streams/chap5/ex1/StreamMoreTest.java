package com.java8.streams.chap5.ex1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMoreTest {

	public static void main(String[] args) {
		createStreamFromListOfStrings();
		createStreamFromArray();
		createFileStream();
		generateNumberStream();
		generate20Fibonacci();
	}

	private static void generate20Fibonacci() {
		System.out.println("***** Fibonacci Series Numbers *****");
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
		.limit(20)
		.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
		
	}

	private static void generateNumberStream() {
		Stream.iterate(0, n -> n + 2)
		.limit(15)
		.forEach(System.out::println);
		
	}

	private static void createFileStream() {
		long uniqueWords = 0;
		try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
			
			uniqueWords = lines.map(line -> Arrays.stream(line.split("")))
					.distinct()
					.count();
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		System.out.println("Unique Words : "+uniqueWords);
		
	}

	private static void createStreamFromArray() {
		int[] numbers = {2,3,4,5,6};
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);
	}

	private static void createStreamFromListOfStrings() {
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
	}

}
