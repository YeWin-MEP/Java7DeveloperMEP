package com.myanmareffectiveprogrammer.java7.smallchanges.missedchanges;

import java.io.IOException;

public class ProcessBuilderImprovement {

	public static void main(String args[]) {
		try {
			runSingleCommand("dir");
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void runSingleCommand(String command)
			throws InterruptedException, IOException {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
		
		/*
		 * Sets the standard input, output, and error streams of the proccess to
		 * those of the Java program
		 */
		builder.inheritIO();
		builder.start().waitFor();
	}
}
