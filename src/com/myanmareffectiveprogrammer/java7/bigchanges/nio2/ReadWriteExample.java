package com.myanmareffectiveprogrammer.java7.bigchanges.nio2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReadWriteExample {

	public static void main(String args[]) throws IOException {
		readFileAsBytes();
		readFileAsString();
		readFileAsSequencesOfLines();

		writeFileAsString();
		writeFileAsCollectionOfLines();
		writeFileAsAppend();
	}

	private static void readFileAsBytes() throws IOException {
		Path path = getReadFilePath();
		
		byte[] bytes = Files.readAllBytes(path);

		print(bytes);
	}

	private static String readFileAsString() throws IOException {
		Path path = getReadFilePath();		
		byte[] bytes = Files.readAllBytes(path);
		
		String content = new String(bytes, StandardCharsets.UTF_8);

		print(content);
		return content;
	}

	private static List<String> readFileAsSequencesOfLines() throws IOException {
		Path path = getReadFilePath();
		
		List<String> lines = Files.readAllLines(path);

		print(lines);
		return lines;
	}

	private static void writeFileAsString() throws IOException {
		String content = readFileAsString();
		Path path = getWriteFilePath();
		
		Files.write(path, content.getBytes(StandardCharsets.UTF_8));
	}

	private static void writeFileAsCollectionOfLines() throws IOException {
		List<String> lines = readFileAsSequencesOfLines();
		Path path = getWriteFilePath();
		
		Files.write(path, lines);
	}

	private static void writeFileAsAppend() throws IOException {
		List<String> lines = readFileAsSequencesOfLines();
		Path path = getWriteFilePath();
		
		Files.write(path, lines, StandardOpenOption.APPEND);
	}

	private static Path getReadFilePath() {
		Path path = Paths
				.get(".\\ReadMe.txt");

		return path.normalize();
	}

	private static Path getWriteFilePath() {
		Path path = Paths
				.get(".\\WriteMe.txt");

		return path;
	}

	private static void print(Object object) {
		System.out.println(object);
	}
}