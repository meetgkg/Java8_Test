package com.java8.chap3.chap3book;

public interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}