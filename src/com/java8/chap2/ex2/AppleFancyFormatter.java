package com.java8.chap2.ex2;

import com.java8.chap2.ex1.Apple;

public class AppleFancyFormatter implements AppleFormatter {
	public String accept(Apple apple) {
		String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
		return "A " + characteristic + " " + apple.getColor() + " apple";
	}
}