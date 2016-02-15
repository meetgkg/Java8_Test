package com.java8.chap3.chap3book;

import java.util.function.IntPredicate;

public class IntPredicateEx {

	public static void main(String[] args) {
		IntPredicate evenNum = (int i) -> i%2 == 0;
		System.out.println(evenNum.test(123));
	}
	

}
