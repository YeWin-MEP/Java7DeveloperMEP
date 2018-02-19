package com.myanmareffectiveprogrammer.java7.smallchanges.exceptionimprovements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExampleExceptionHandlingLazy {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.myanmareffectiveprogrammer.com/");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line = reader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
			Date date = format.parse(line);
		} catch (Exception exception) {
			// I am an inexperienced or lazy programmer here.
		}
	}
}
