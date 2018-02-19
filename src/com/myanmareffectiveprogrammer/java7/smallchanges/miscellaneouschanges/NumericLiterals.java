package com.myanmareffectiveprogrammer.java7.smallchanges.miscellaneouschanges;

public class NumericLiterals {

	public static void main(String args[]) {

		Java6Literals();
		
		Java7Literals();
	}
	
	private static void Java6Literals() {
		
		int x = Integer.parseInt("1100110", 2);
		System.out.println(x);
	}
	
	private static void Java7Literals() {
		
		int x = 0b1100110;
		System.out.println(x);
	}
}
