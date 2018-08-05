package compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip2 {
	static final int BUFFER = 2048;

	/**
	 * Command line arguments : argv[0]-----> Source directory. argv[1]-----> Destination zip file.
	 **/
	public static void main(String[] args) {

		zipFile(args[0], args[1]);
	}

	public static void zipFile(String src, String dest) {

		FileOutputStream destination = null;
		try {
			destination = new FileOutputStream(dest);
		} catch (FileNotFoundException e) {
			System.out.println("Output directory does not exist..");
			e.printStackTrace();
		}

		/** Step: 1 ---> create a ZipOutputStream object. **/
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(destination));

		/**
		 * Step: 2 --->Open the source data and get a list of files from given directory recursively.
		 **/
		File source = new File(src);
		if (!source.exists()) {
			System.out.println("Input directory does not exist..");
			System.exit(0);
		}
		try {

			zipFilesRecursively(source.getParentFile(), source, out);

			/** Step: 6 --->close the output stream. **/
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void zipFilesRecursively(File baseDir, File source, ZipOutputStream out) throws IOException {

		if (source.isFile()) {

			System.out.println("Adding File: " + baseDir.toURI().relativize(source.toURI()).getPath());

			FileInputStream fi = new FileInputStream(source);
			BufferedInputStream sourceStream = new BufferedInputStream(fi, BUFFER);

			/** Step: 3 ---> Create a zip entry for each file that is read. **/
			/**
			 * relativize is used to to add a file to a zip, without including the entire path from root.
			 **/

			ZipEntry entry = new ZipEntry(baseDir.toURI().relativize(source.toURI()).getPath());

			/** Step: 4 ---> Put the zip entry using putNextEntry. **/
			out.putNextEntry(entry);

			/**
			 * Step: 5 ---> Write the data to the ZIP file and close the input stream.
			 **/
			int count;
			byte data[] = new byte[BUFFER];
			while ((count = sourceStream.read(data, 0, BUFFER)) != -1) {
				out.write(data, 0, count);
			}
			sourceStream.close();

		} else {

			if (source.listFiles() != null) {

				/** Add an empty folder to the zip **/
				if (source.listFiles().length == 0) {

					System.out.println("Adding Empty Folder: " + baseDir.toURI().relativize(source.toURI()).getPath());
					ZipEntry entry = new ZipEntry(baseDir.toURI().relativize(source.toURI()).getPath() + File.separator);
					out.putNextEntry(entry);

				}

				for (File file : source.listFiles())

					zipFilesRecursively(baseDir, file, out);
			}
		}
	}
}
