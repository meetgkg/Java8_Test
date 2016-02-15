package com.java8.chap3.chap3book;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {
	
	public static void main(String[] args) {
		noSignature();
		
		withSignature();
		
		withManyArguments();
	}

	private static void noSignature() {
		Supplier<Apple> c1 = () -> new Apple();
		Apple a1 = c1.get();
		
		
		Supplier<Apple> c2 = Apple::new;
		Apple a2 = c1.get();
	}
	
	private static void withSignature() {
		Function<Integer, Apple> c1 = (weight) -> new Apple(weight);
		Apple a1 = c1.apply(100);
		System.out.println(a1.getWeight());
		
		Function<Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(200);
		System.out.println(a2.getWeight());
	}
	
	
	private static void withManyArguments() {
		BiFunction<String, Integer, Apple> c1 = (color, weight) -> new Apple(color, weight);
		Apple a1 = c1.apply("green", 120);
		System.out.println("Color : " + a1.getColor()+" Weight : " + a1.getWeight());
		
		BiFunction<String, Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply("red", 160);
		System.out.println("Color : " + a2.getColor()+" Weight : " + a2.getWeight());
	}

}
