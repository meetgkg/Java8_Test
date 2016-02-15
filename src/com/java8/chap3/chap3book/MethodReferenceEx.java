package com.java8.chap3.chap3book;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenceEx {

	public static void main(String[] args) {
		System.out.println("Test1");
		test1();
		
		System.out.println("Test2");
		test2();
		
		System.out.println("Test3");
		test3();
	}

	private static void test1() {
		List<String> str = Arrays.asList("a","b","A","B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(str);
		
		List<String> str1 = Arrays.asList("a","b","A","B","c","D");
		str1.sort(String::compareToIgnoreCase);
		System.out.println(str1);
	}
	
	private static void test2() {
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		
		Function<String, Integer> stringToInteger2 = Integer::parseInt;
	}
	
	private static void test3() {
		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		BiPredicate<List<String>, String> contains2 = List::contains;
	}
	

}
