package com.myanmareffectiveprogrammer.java7.bigchanges.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

	public static void main(String[] args) {

		creatingAbsolutePath();
		creatingRelativePath();
		oneDotExample();
		twoDotExample();
	}

	private static void creatingAbsolutePath() {
		Path absolutePath = Paths
				.get("D:\\msp_paltform\\mep_workspace\\java7developermep\\ReadMe.txt");

		print(absolutePath);
	}

	private static void creatingRelativePath() {
		Path relativePath = Paths.get(
				"D:\\msp_paltform\\mep_workspace\\java7developermep",
				"ReadMe.txt"); // Paths.get(basePath, relativePath)

		print(relativePath);
	}

	private static void oneDotExample() {
		Path currentDir1 = Paths.get(".");
		print(currentDir1.toAbsolutePath().normalize());

		Path currentDir2 = Paths
				.get("D:\\msp_paltform\\mep_workspace\\.\\java7developermep");
		print(currentDir2.toAbsolutePath().normalize());
	}

	private static void twoDotExample() {
		Path currentDir1 = Paths.get("..");
		print(currentDir1.toAbsolutePath().normalize());

		Path currentDir2 = Paths
				.get("D:\\msp_paltform\\mep_workspace\\..\\java7developermep");
		print(currentDir2.toAbsolutePath().normalize());
	}
	
	private static void print(Path path) {
		System.out.println(path);
	}
}
