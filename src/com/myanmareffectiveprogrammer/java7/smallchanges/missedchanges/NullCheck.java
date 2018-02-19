package com.myanmareffectiveprogrammer.java7.smallchanges.missedchanges;

import java.util.Objects;

public class NullCheck {

	public static void main(String args[]) {
		nullCheck(null);
	}

	private static void nullCheck(String value) {
		Objects.requireNonNull(value, "value must not be null");
	}
}
