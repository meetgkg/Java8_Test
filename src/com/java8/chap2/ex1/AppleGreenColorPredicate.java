package com.java8.chap2.ex1;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor());
	}

}
