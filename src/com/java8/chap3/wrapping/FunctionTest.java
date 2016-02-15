package com.java8.chap3.wrapping;

import java.util.function.DoubleFunction;
import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> x+1;
		Function<Integer, Integer> g = x -> x*2;
		Function<Integer, Integer> h = f.andThen(g);
		int result = h.apply(3);//g( f(x) )
		System.out.println(result);
		
		
		Function<Integer, Integer> k = f.compose(g);
		int result2 = k.apply(3);//f( g(x) )
		System.out.println(result2);
		
		double area = integrate((double x) -> x + 10, 3, 7);
		System.out.println(area);
	}
	
	
	public static double integrate(DoubleFunction<Double> f, double a, double b) {
		return (f.apply(a) + f.apply(b)) * (b-a) / 2.0;
	}

}
