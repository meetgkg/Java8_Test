package com.java8.streams.chap5.ex1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RangeTest {

	public static void main(String[] args) {
		getRange();
	}
	
	private static void getRange(){
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
											.filter( n -> n%2 == 0 );
		
		System.out.println(evenNumbers.count());
		
		getPythagorusTriples();
	}
	
	
	private static void getPythagorusTriples(){
		Stream<int[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
				.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
				.mapToObj(b ->
				new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
				);
		
		pythagoreanTriples.limit(5)
		.forEach(t ->
		System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}
}
