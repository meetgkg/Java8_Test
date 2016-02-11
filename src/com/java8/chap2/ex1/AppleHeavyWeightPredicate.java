package com.java8.chap2.ex1;

public class AppleHeavyWeightPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}

}
