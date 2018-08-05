package file;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class LargeFileWriter {
	public static void main(String[] args) throws IOException {
		new LargeFileWriter().doit();
	}

	private void doit() throws IOException {
		// int[] mbs = new int[] { 50, 100, 250, 500, 1000, 2000 };
		int[] mbs = new int[] { 500, 1000, 2000, 3000, 5000 };

		// testFileSizeWithPrintWriter(mbs[0]);
		// testFileSizeWithNioChannel(mbs[0]);
		for (int mb : mbs) {
			testFileSizeWithPrintWriter(mb);
			testFileSizeWithFileWriter(mb);
			testFileSizeWithFileOutputStream(mb);
			testFileSizeWithBufferdWriter(mb);
			testFileSizeWithBufferStream(mb);
			testFileSizeWithNioChannel(mb);
			System.out.println("==========================================================================");

		}

	}

	private void testFileSizeWithBufferStream(int mb) throws IOException {
		File file = File.createTempFile("test", ".txt");
		file.deleteOnExit();

		long startTime = System.nanoTime();
		OutputStream out = new FileOutputStream(file);
		OutputStream outBuffer = new BufferedOutputStream(out);
		for (int i = 0; i < mb * 1024; i++) {
			out.write(getContents().getBytes());
		}
		outBuffer.close();
		long elapsedTime = System.nanoTime() - startTime;
		log("BufferedOutputStream", file.length(), elapsedTime);

	}

	private void testFileSizeWithFileWriter(int mb) throws IOException {
		File file = File.createTempFile("test", ".txt");
		// File file = new File("target/test.txt");
		file.deleteOnExit();

		long startTime = System.nanoTime();
		FileWriter fw = new FileWriter(file);
		for (int i = 0; i < mb * 1024; i++) {
			fw.write(getContents());
		}
		fw.close();
		long elapsedTime = System.nanoTime() - startTime;
		log("FileWriter", file.length(), elapsedTime);
	}

	private void testFileSizeWithBufferdWriter(int mb) throws IOException {
		File file = File.createTempFile("test", ".txt");
		// File file = new File("target/test.txt");
		file.deleteOnExit();

		long startTime = System.nanoTime();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < mb * 1024; i++) {
			bw.write(getContents());
		}
		bw.close();
		long elapsedTime = System.nanoTime() - startTime;
		log("BufferedWriter", file.length(), elapsedTime);
	}

	private void testFileSizeWithNioChannel(int mb) throws IOException {
		File file = File.createTempFile("test", ".txt");
		// File file = new File("target/test.txt");
		file.deleteOnExit();

		long startTime = System.nanoTime();
		FileChannel out = new RandomAccessFile(file, "rw").getChannel();
		for (int i = 0; i < mb * 1024; i++) {
			out.write(ByteBuffer.wrap(getContents().getBytes()));
		}
		out.close();
		long elapsedTime = System.nanoTime() - startTime;
		log("FileChannel", file.length(), elapsedTime);
	}

	private void testFileSizeWithFileOutputStream(int mb) throws IOException {
		File file = File.createTempFile("test", ".txt");
		// File file = new File("target/test.txt");
		file.deleteOnExit();

		long startTime = System.nanoTime();
		FileOutputStream fos = new FileOutputStream(file);
		for (int i = 0; i < mb * 1024; i++) {
			fos.write(getContents().getBytes());
		}
		fos.flush();
		fos.close();

		long elapsedTime = System.nanoTime() - startTime;
		log("FileOutputStream", file.length(), elapsedTime);
	}

	private void testFileSizeWithPrintWriter(int mb) throws IOException {
		File file = File.createTempFile("test", ".txt");
		// File file = new File("test.txt");
		file.deleteOnExit();

		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		for (int i = 0; i < mb * 1024; i++) {
			pw.println(getContents());
		}
		pw.flush();
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		log("PrintWriter", file.length(), elapsedTime);
	}

	private void log(String ioType, long fileLenth, long elapsedTime) {
		System.out.printf("[" + ioType + "] Took %.3f seconds to write to a %d MB, file rate: %.1f MB/s%n",
				elapsedTime / 1e9, fileLenth >> 20, fileLenth * 1000.0 / elapsedTime);
	}

	public String getContents() throws IOException {
		char[] chars = new char[1024];
		Arrays.fill(chars, 'A');
		String longLine = new String(chars);

		return longLine;
	}
}
