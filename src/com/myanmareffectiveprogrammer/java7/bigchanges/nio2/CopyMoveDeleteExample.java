package com.myanmareffectiveprogrammer.java7.bigchanges.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyMoveDeleteExample {

	public static void main(String args[]) throws IOException {
		copyMoveDeleteExample();
	}

	/*
	 * If you test with this method, make sure yourself that you have the actual
	 * testing files in correct location.
	 */
	private static void copyMoveDeleteExample() throws IOException {
		Path fromPath = getFromFilePath();
		Path toPath = getToFilePath();

		/* To copy a file from one location to another, simply call */
		Files.copy(fromPath, toPath);

		/* To move a file (that is, copy and delete the original), call */
		Files.move(fromPath, toPath);

		/*
		 * The copy or move will fail if the target exists. If you to overwrite
		 * an existing target, use the REPLACE_EXISTING options. If you want to
		 * copy all the file attributes, use the COPY_ATTRIBUTES option. You can
		 * supply both like this:
		 */
		Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES);

		/*
		 * You can specify that a move should be atomic. Then you are assured
		 * that either the move completed successfully, or the source continues
		 * to be present. Use the ATOMIC_MOVE option.
		 */
		Files.move(fromPath, toPath, StandardCopyOption.ATOMIC_MOVE);

		/* To delete a file, simply call */
		Files.delete(toPath);

		/*
		 * Files.delete(toPath) method throws an exception if the file doesn't
		 * exist, so instead you may want to use
		 */
		Files.deleteIfExists(toPath);

	}

	private static Path getFromFilePath() {
		Path path = Paths.get(".\\from\\Test.txt");

		return path.normalize();
	}

	private static Path getToFilePath() {
		Path path = Paths.get(".\\to\\TestCopy.txt");

		return path.normalize();
	}
}
