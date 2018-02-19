package com.myanmareffectiveprogrammer.java7.smallchanges.exceptionimprovements;

import java.io.IOException;

public class ExampleExceptionRethrowOld {

	public static void demoRethrow() {
		try {
			throw new IOException("Error");
		} catch (IOException exception) {
			/*
			 * Do some handling and then rethrow.
			 */
			throw new RuntimeException(exception);
		}
	}

	public static void main(String[] args) {
		try {
			demoRethrow();
		} catch (RuntimeException exception) {
			System.err.println(exception.getCause().getMessage());
		}
	}
}
