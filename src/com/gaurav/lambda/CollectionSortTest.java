package com.gaurav.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortTest {
	
	static List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

	public static void main(String[] args) {

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});		
		System.out.println(names);
		
		System.out.println("Using Java 8 Lambda");
		Collections.sort(names, (String a, String b) -> {
		    return a.compareTo(b);
		});
		System.out.println(names);
		
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		System.out.println(names);
		
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println(names);
	}
}
