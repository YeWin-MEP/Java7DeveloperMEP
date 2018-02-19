package com.myanmareffectiveprogrammer.java7.smallchanges.exceptionimprovements;

import java.io.IOException;

public class ExampleExceptionRethrowSE7 {

	public static void demoRethrow() throws IOException {
		try {
			throw new IOException("Error");
		} catch (Exception exception) {			
			/*
			 * Do some handling and then rethrow.
			 */
			throw exception;
		}
	}

	public static void main(String[] args) {
		try {
			demoRethrow();
		} catch (IOException exception) {
			System.err.println(exception.getMessage());
		}
	}
}
