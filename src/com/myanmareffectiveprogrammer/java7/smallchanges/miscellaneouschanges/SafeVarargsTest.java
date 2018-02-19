package com.myanmareffectiveprogrammer.java7.smallchanges.miscellaneouschanges;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargsTest {

	//varargs method
	@SafeVarargs
	static void call(List<String>... stringLists) {
		String s = stringLists[0].get(0);
		System.out.println(s);
	}

	//calling method
	public static void main(String args[]) {
		List<String> myList1 = new ArrayList<>();
		List<String> myList2 = new ArrayList<>();

		myList1.add("A");
		myList2.add("B");

		call(myList1, myList2); 
		//No warning message here.
	}
	
	@SafeVarargs
	// WARNING SUPPRESSED: Type safety: Potential heap pollution via varargs parameter a
	public static <T> void print(T... a) {
	  for (T t : a) {
	      System.out.println(t);
	  }
	}
}
