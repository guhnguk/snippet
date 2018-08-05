package compress;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Gzip {

	final static String decompressedFile = "c:/testFile.txt";
	final static String decompressedFile2 = "c:/testFile2.txt";
	final static String compressedFile = "c:/testFile.txt.gz";

	public static void main(String[] args) {
		Gzip test = new Gzip();
		try {
			System.out.println("start compress ...");
			test.compress();

			System.out.println("start decompress ...");
			test.decompress();

			System.out.println("complete compress/decompress process");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void compress() throws IOException {

		long startTime = startTime = System.currentTimeMillis();

		BufferedReader in = new BufferedReader(new FileReader(decompressedFile));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(compressedFile)));

		String s;
		while (null != (s = in.readLine())) {
			out.write(s.getBytes());
			out.write("\n".getBytes());
		}
		in.close();
		out.close();

		long endTime = System.currentTimeMillis();
		System.out.println("compress elapsed time : " + (endTime - startTime) + " ms");
	}

	public void decompress() throws FileNotFoundException, IOException, InterruptedException {

		long startTime = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
				new FileInputStream(compressedFile))));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(decompressedFile2));

		String s;
		while (null != (s = in.readLine())) {
			out.write(s.getBytes());
			out.write("\n".getBytes());
		}
		in.close();
		out.close();

		long endTime = System.currentTimeMillis();
		System.out.println("decompress elapsed time : " + (endTime - startTime) + " ms");

	}
}