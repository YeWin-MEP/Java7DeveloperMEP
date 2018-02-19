package com.myanmareffectiveprogrammer.java7.smallchanges.exceptionimprovements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResourcesExampleOld {

	public static void main(String[] args) {
		
		BufferedReader reader = null;

		try {
			URL url = new URL("https://www.myanmareffectiveprogrammer.com/");
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
			Date date = format.parse(line);
			
		} catch (MalformedURLException exception) {
			// handle passing in the wrong type of URL.
		} catch (IOException exception) {
			// handle I/O problems.
		} catch (ParseException exception) {
			// handle date parse problems.
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
