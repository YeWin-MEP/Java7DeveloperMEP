package com.myanmareffectiveprogrammer.java7.bigchanges.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelExample {

	public static void main(String args[]) {
		try {
			readViaFuture();
			readViaCallBack();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readViaFuture() throws IOException {
		Path path = getReadFilePath();

		/* 1. Open file asynchronously */
		AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
				path, StandardOpenOption.READ);

		/* 2. Start to read 1024 bytes */
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;
		Future<Integer> result = fileChannel.read(buffer, position);

		while (!result.isDone()) {
			/* 3. Do other important work until read is done */
			otherImportantWork();
		}

		/*4. Get results*/
		printReadData(buffer);

		buffer.clear();
	}

	private static void readViaCallBack() throws IOException {
		Path path = getReadFilePath();

		/* Open file asynchronously */
		AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
				path, StandardOpenOption.READ);

		/* Start to read 1024 bytes */
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;

		fileChannel.read(buffer, position, buffer,
				new CompletionHandler<Integer, ByteBuffer>() {			
					/*Complete Reading Callback*/
					@Override
					public void completed(Integer result, ByteBuffer attachment) {
						System.out.println("Count = " + result);
						printReadData(attachment);
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						exc.printStackTrace();
					}
				});
		otherImportantWork();		
	}

	private static Path getReadFilePath() throws IOException {
		Path path = Paths.get(".\\ReadMe.txt");

		return path.normalize();
	}

	private static void printReadData(ByteBuffer buffer) {
		buffer.flip();
		byte[] data = new byte[buffer.limit()];
		buffer.get(data);
		print(new String(data));
	}

	private static void print(Object object) {
		System.out.println(object);
	}
	
	private static void otherImportantWork() {		
		System.out.println("Other important work");
	}
}
