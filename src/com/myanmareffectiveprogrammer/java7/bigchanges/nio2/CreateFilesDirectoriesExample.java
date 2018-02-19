package com.myanmareffectiveprogrammer.java7.bigchanges.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFilesDirectoriesExample {

	public static void main(String args[]) throws IOException {
		createFilesAndDirectories();
		convenienceMethodsForCreatingTemporaryFile();
	}

	private static void createFilesAndDirectories() throws IOException {
		Path path = getAbsolutePath();

		/*
		 * To create a new directory, call (it will throw the errors if parent
		 * "foo" directory is not exist.
		 */
		try {
			Files.createDirectory(path);
		} catch (IOException e) {
			print("java.nio.file.NoSuchFileException: Because parent directory foo is not exist");
		}

		/*
		 * To create a directory several levels deep when one or more of the
		 * parent directories might not yet exist, you can use the convenience
		 * method call...
		 */
		Files.createDirectories(path);

		Path newFile = Paths.get(path.toString(), "NewFile.txt");
		/* You can create an empty file as below */
		Files.createFile(newFile);
		
		Files.delete(newFile);

	}
	
	private static void convenienceMethodsForCreatingTemporaryFile() throws IOException {
		Path path = getAbsolutePath();
		
		Files.createTempFile(path, "Prefix", "Suffix");
		Files.createTempDirectory(path, "Prefix");
	}

	private static Path getAbsolutePath() {
		Path absolutePath = Paths.get(".\\foo\\bar");

		return absolutePath.normalize();
	}

	private static void print(Object object) {
		System.out.println(object);
	}
}
