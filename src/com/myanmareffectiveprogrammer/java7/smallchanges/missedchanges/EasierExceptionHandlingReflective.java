package com.myanmareffectiveprogrammer.java7.smallchanges.missedchanges;

import java.lang.reflect.InvocationTargetException;

public class EasierExceptionHandlingReflective {

	public static void main(String args[]) {
		beforeJava7();
		java7();
	}

	private static void beforeJava7() {
		try {
			Class.forName("ClassName").getMethod("main")
					.invoke(null, new String[] {});
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	private static void java7() {
		try {
			Class.forName("ClassName").getMethod("main")
					.invoke(null, new String[] {});
		} catch (ReflectiveOperationException e) {			
			e.printStackTrace();
		}
	}
}
