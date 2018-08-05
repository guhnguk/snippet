package compress;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GzipManager {
	final static String str = ":날 위해 감춰왔던 아픔이 보여요 You and I together it's just feel alright";

	public static void main(String[] args) {
		BufferedWriter out = null;
		String fileName = "c:/testFile.txt";
		File file = new File(fileName);
		try {
			out = new BufferedWriter(new FileWriter(fileName));
			long lineNum = 1;
			while (true) {
				out.write((lineNum++) + str);
				out.newLine();
				if (0 == lineNum % 10000) { // byte 단위 - 1GB보다 크다면
					if (file.length() > 1073741824L)
						break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != out)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
