package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileSpliter {
	public static void main(String[] args) throws IOException {
		String filePos = "/Users/Ryan/Developer/workspace/java-snippet/part-r-00001";
		
		if (args.length !=3) {
			System.out.println("Usage: FileLineSpliter <file> <opt:-l, -s> <line-count>");
			System.exit(1);
		}
		
		filePos = args[0];
		int splitCount = Integer.parseInt(args[1]);
		
		String NEWLINE = System.getProperty("line.separator");
		BufferedReader in = new BufferedReader(new FileReader(filePos));
		LineNumberReader reader = new LineNumberReader(in);
		
		String str = null;
		StringBuilder sb = new StringBuilder(512);
		int lineCount = 0;
		
		int fileCount = 0;
		while ((str = reader.readLine()) != null) {
			sb.append(str).append(NEWLINE);
			lineCount++;
			
			if (lineCount >= splitCount) {
				write(sb.toString(), filePos + "_" + fileCount++);
				sb.setLength(0);
				lineCount = 0;
			}
			
		}
		
	}
	
	public static void write(String text, String filePath) throws IOException {
		File f = new File(filePath);
		FileWriter writer = new FileWriter(f);
		writer.write(text);
		writer.close();
	}
	
}
