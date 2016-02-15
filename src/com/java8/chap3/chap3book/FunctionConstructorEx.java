package com.java8.chap3.chap3book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionConstructorEx {
	public static void main(String[] args) {
		List<Integer> weights = Arrays.asList(4,5,6,7,8,2,11);
		List<Apple> apples = map(weights, Apple::new);
		System.out.println(apples.toString());
	}

	private static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
		List<Apple> resultSet = new ArrayList<Apple>();
		for(Integer e: weights){
			resultSet.add(f.apply(e));
		}
		return resultSet;
	}
}
