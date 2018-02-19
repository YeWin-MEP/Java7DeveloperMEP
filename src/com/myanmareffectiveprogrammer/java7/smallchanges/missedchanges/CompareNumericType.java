package com.myanmareffectiveprogrammer.java7.smallchanges.missedchanges;

public class CompareNumericType {
	int x;
	int y;

	public static void main(String args[]) {
		new CompareNumericType().compareToBeforeJava7();
		new CompareNumericType().compareToJava7();

	}

	private int compareToBeforeJava7() {
		int diff = x - 5000; // Risk of overflow
		if (diff != 0)
			return diff;
		return y - 500;
	}
	
	private int compareToJava7() {
		int diff = Integer.compare(x, 5000); // No risk of overflow
		if (diff != 0)
			return diff;
		return Integer.compare(y, 5000);
	}
}
