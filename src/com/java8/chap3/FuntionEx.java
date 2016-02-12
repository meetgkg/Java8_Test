package com.java8.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FuntionEx {

	public static void main(String[] args) {
		List<Integer> list = map(Arrays.asList("Gaurav","Anamika","Ankit333"), (String s) -> s.length() );
		System.out.println(list);
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f){
		List<R> result = new ArrayList<R>();
		for(T s : list){
			result.add(f.apply(s));
		}
		return result;
	}

}
