package com.java8.chap2.ex2;

import com.java8.chap2.ex1.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
	public String accept(Apple apple) {
		return "An apple of " + apple.getWeight() + "g";
	}
}