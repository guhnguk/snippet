package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileSum {
	public static void main(String[] args) throws IOException {
		String file1 = "/Users/Ryan/Developer/workspace/bdw-mapred/data/20120910/20/4G/part-r-00008";
		String file2 = "/Users/Ryan/Developer/workspace/bdw-mapred/data/20120910/20/4G/part-r-00018";

		String files[] = { file1, file2 };
		args = files;

		if (args.length < 2) {
			System.out.println("Usage: FileLineSpliter <file list>...");
			System.exit(1);
		}

		FileSum fs = new FileSum();

		StringBuilder sb = new StringBuilder(1024);
		for (int i = 0, length = args.length; i < length; i++) {
			sb.append(fs.getSumFile(args[i]));
		}

		write(sb.toString(), "/Users/Ryan/Developer/workspace/bdw-mapred/data/20120910/20/4G/new-sum-file");
		System.out.println("File sum completed!");
	}

	private String getSumFile(String file) throws FileNotFoundException, IOException {
		String NEWLINE = System.getProperty("line.separator");
		BufferedReader in = new BufferedReader(new FileReader(file));
		LineNumberReader reader = new LineNumberReader(in);

		String str = null;
		StringBuilder sb = new StringBuilder(1024);
		while ((str = reader.readLine()) != null) {
			sb.append(str).append(NEWLINE);
		}

		return sb.toString();
	}

	public static void write(String text, String filePath) throws IOException {
		File f = new File(filePath);
		FileWriter writer = new FileWriter(f);
		writer.write(text);
		writer.close();
	}
}
