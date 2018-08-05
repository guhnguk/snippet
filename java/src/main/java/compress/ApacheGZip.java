package compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

public class ApacheGZip {

	public void uncompressGzip() throws IOException {
		FileInputStream fin = new FileInputStream("tmp/sh1.tar.gz");
		BufferedInputStream in = new BufferedInputStream(fin);

		FileOutputStream out = new FileOutputStream("tmp/sh1.tar");

		GzipCompressorInputStream gzIn = new GzipCompressorInputStream(in);
		final byte[] buffer = new byte[1024 * 8];
		int n = 0;
		while (-1 != (n = gzIn.read(buffer))) {
			out.write(buffer, 0, n);
		}
		out.close();
		gzIn.close();
	}

	public void compressGzip() throws FileNotFoundException, IOException {
		GZIPOutputStream out = null;
		String filePaths[] = { "C:/Temp/1.txt", "C:/Temp/2.txt" };
		try {
			out = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream("C:/Temp/myfile.gz")));

			RandomAccessFile f = new RandomAccessFile(filePaths[0], "r");
			byte[] b = new byte[(int) f.length()];
			f.read(b);
			out.write(b, 0, b.length);

			out.finish();
			out.close();
		} finally {
			if (out != null)
				out.close();
		}
	}

	public static void main(String[] args) throws IOException {
		// new ApacheGZip().uncompressGzip();
		new ApacheGZip().compressGzip();
	}
}
