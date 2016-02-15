package com.java8.chap3.chap3book;

public class LocalVariableTest {

	public static void main(String[] args) {
		int portNumber = 100;
		
		Runnable r = () -> System.out.println(portNumber);
		
		//portNumber = 200;//Throws Error.

	}

}
