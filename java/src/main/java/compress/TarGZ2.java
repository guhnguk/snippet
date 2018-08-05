package compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

/**
 * Creating a tar.gz with apache commons-compress.
 **/
public class TarGZ2 {
	static final int BUFFER = 2048;

	/**
	 * Command line arguments : argv[0]-----> Source directory. argv[1]-----> Destination tar.gz file.
	 **/
	public static void main(String[] args) {

		zipFile(args[0], args[1]);
	}

	public static void zipFile(String src, String dest) {

		FileOutputStream destination = null;
		BufferedOutputStream bOut = null;
		GzipCompressorOutputStream gzOut = null;
		TarArchiveOutputStream tOut = null;

		try {
			destination = new FileOutputStream(dest);
		} catch (FileNotFoundException e) {
			System.out.println("Output directory does not exist..");
			e.printStackTrace();
		}

		/** Step: 1 ---> create a TarArchiveOutputStream object. **/
		try {
			bOut = new BufferedOutputStream(destination);
			gzOut = new GzipCompressorOutputStream(bOut);
			tOut = new TarArchiveOutputStream(gzOut);
			/**
			 * Step: 2 --->Open the source data and get a list of files from given directory recursively.
			 **/

			File source = new File(src);
			if (!source.exists()) {
				System.out.println("Input directory does not exist..");
				System.exit(0);
			}

			zipFilesRecursively(source.getParentFile(), source, tOut);

			/** Step: 7 --->close the output stream. **/

			tOut.close();

			System.out.println("tar.gz file created successfully!!");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void zipFilesRecursively(File baseDir, File source, TarArchiveOutputStream out) throws IOException {

		if (source.isFile()) {

			System.out.println("Adding File: " + baseDir.toURI().relativize(source.toURI()).getPath());

			FileInputStream fi = new FileInputStream(source);
			BufferedInputStream sourceStream = new BufferedInputStream(fi, BUFFER);

			/** Step: 3 ---> Create a tar entry for each file that is read. **/

			/**
			 * relativize is used to to add a file to a tar, without including the entire path from root.
			 **/

			TarArchiveEntry entry = new TarArchiveEntry(source, baseDir.getParentFile().toURI().relativize(source.toURI())
					.getPath());

			/** Step: 4 ---> Put the tar entry using putArchiveEntry. **/

			out.putArchiveEntry(entry);

			/**
			 * Step: 5 ---> Write the data to the tar file and close the input stream.
			 **/

			int count;
			byte data[] = new byte[BUFFER];
			while ((count = sourceStream.read(data, 0, BUFFER)) != -1) {
				out.write(data, 0, count);
			}
			sourceStream.close();

			/** Step: 6 --->close the archive entry. **/

			out.closeArchiveEntry();

		} else {

			if (source.listFiles() != null) {

				/** Add an empty folder to the tar **/

				if (source.listFiles().length == 0) {

					System.out.println("Adding Empty Folder: " + baseDir.toURI().relativize(source.toURI()).getPath());
					TarArchiveEntry entry = new TarArchiveEntry(source, baseDir.getParentFile().toURI()
							.relativize(source.toURI()).getPath());
					out.putArchiveEntry(entry);
					out.closeArchiveEntry();

				}

				for (File file : source.listFiles())

					zipFilesRecursively(baseDir, file, out);
			}
		}
	}
}
