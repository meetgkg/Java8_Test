package com.java8.streams.chap5.quiz;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainApp {

	public static void main(String[] args) {
		
		List<Transaction> transactions = getTransactionList();
		System.out.println("Problem 1");
		sort2011Transactions(transactions);
		
		System.out.println("\n Problem 2");
		findUniqueTradersCity(transactions);
		
		System.out.println("\n Problem 3");
		sortAndFindCambridgeTrades(transactions);
		
		System.out.println("\n Problem 4");
		stringAllTradersAlphabet(transactions);
		
		System.out.println("\n Problem 5");
		isAnyTraderInMilan(transactions);
		
		System.out.println("\n Problem 6");
		txnValueOfCamb(transactions);
		
		System.out.println("\n Problem 7");
		highestTxnValue(transactions);
		
		System.out.println("\n Problem 8");
		smallestTxnValue(transactions);
	}
	
	//8. Find the transaction with the smallest value.
	private static void smallestTxnValue(List<Transaction> transactions) {
		Optional<Transaction> minTransaction = transactions.stream()
							.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(minTransaction.toString());
	}
	
	//7. What’s the highest value of all the transactions?
	private static void highestTxnValue(List<Transaction> transactions) {
		Optional<Integer> maxValue = 
		transactions.stream()
		.map(T -> T.getValue())
		.reduce(Integer::max);
		
		System.out.println(maxValue.get());
	}

	//6. Print all transactions’ values from the traders living in Cambridge.
	private static void txnValueOfCamb(List<Transaction> transactions) {
		transactions.stream()
		.filter(T -> T.getTrader().getCity().equals("Cambridge"))
		.map(T -> T.getValue())
		.forEach(System.out::println);
	}

	//5. Are any traders based in Milan?
	private static void isAnyTraderInMilan(List<Transaction> transactions) {
		boolean isMilan = transactions.stream()
		.anyMatch(T -> T.getTrader().getCity().equals("Milan"));
		
		if(isMilan){
			System.out.println("Atleast One Trader is in Milan");
		}else{
			System.out.println("No Trader is in Milan");
		}
	}

	//4. Return a string of all traders’ names sorted alphabetically
	private static void stringAllTradersAlphabet(List<Transaction> transactions) {
		String list = transactions.stream()
				.map(T -> T.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (n1,n2)-> n1+n2);
		
		System.out.println(list.toString());
		
		String list2 = transactions.stream()
				.map(T -> T.getTrader().getName())
				.distinct()
				.sorted()
				.collect(joining());
		
		System.out.println(list2.toString());
	}

	//3. Find all traders from Cambridge and sort them by name.
	private static void sortAndFindCambridgeTrades(List<Transaction> transactions) {
		List<String> cambTraders = 
				transactions.stream()
				.filter(T -> T.getTrader().getCity().equalsIgnoreCase("Cambridge"))
				.map(T -> T.getTrader().getName())
				.distinct()
				.sorted()
				.collect(toList());
		
		System.out.println(cambTraders);
	}

	//2. What are all the unique cities where the traders work?
	private static void findUniqueTradersCity(List<Transaction> transactions) {
		List<String> cityList = 
		transactions.stream()
		.map(T -> T.getTrader())
		.map(Tr -> Tr.getCity())
		.distinct()
		.collect(toList());
		
		System.out.println(cityList.toString());
	}

	//1. Find all transactions in the year 2011 and sort them by value (small to high).
	private static void sort2011Transactions(List<Transaction> transactions) {
		List<Transaction> txn2011 = transactions.stream()
		.filter(T -> T.getYear() == 2011)
		.sorted(comparing(Transaction::getValue))
		.collect(toList());
		
		System.out.println(txn2011.toString());
	}
	
	
	private static List<Transaction> getTransactionList() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950)
			);
		return transactions;

	}

}
