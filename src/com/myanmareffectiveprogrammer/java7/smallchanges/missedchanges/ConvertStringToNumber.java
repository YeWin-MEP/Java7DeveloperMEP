package com.myanmareffectiveprogrammer.java7.smallchanges.missedchanges;

public class ConvertStringToNumber {
	
	public static void main(String args[]) {
		convertStringToNumberJava7();
	}

	private static void convertStringToNumberJava7() {
		/*Before Java 7, +1.0 is not a valid double number*/
		double x = Double.parseDouble("+1.0");
		
		/*Before Java 7, +1 is not a valid integer number*/
		int n = Integer.parseInt("+1");
		
		print(x);
		print(n);
	}
	
	private static void print(Object object) {
		System.out.println(object);
	}
}
