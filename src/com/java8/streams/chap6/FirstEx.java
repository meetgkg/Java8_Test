package com.java8.streams.chap6;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java8.streams.chap5.quiz.Transaction;

public class FirstEx {

	public static void main(String[] args) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		Map<Integer, List<Transaction>> transactionsByCurrencies =
				transactions.stream().collect(groupingBy(Transaction::getValue));
		
		/*List<Apple> greenApples = inventory.stream().filter((Apple a) -> 
											"green".equals(a.getColor()) ).collect(toList());*/
	}

}
