package compress;

import java.io.*;
import java.util.zip.*;

public class Zip {
	static final int BUFFER = 2048;

	/**
	 * Command line arguments : argv[0]-----> Source directory. argv[1]-----> Destination zip file.
	 **/
	public static void main(String argv[]) {
		try {

			BufferedInputStream origin = null;

			/** Step: 1 ---> create a ZipOutputStream object. **/

			FileOutputStream dest = new FileOutputStream(argv[1]);
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

			// out.setMethod(ZipOutputStream.DEFLATED);
			byte data[] = new byte[BUFFER];

			/**
			 * Step: 2 --->Open the source data and get a list of files from given directory.
			 **/
			File source = new File(argv[0]);
			if (!source.exists()) {
				System.out.println("Input directory does not exist..");
				System.exit(0);
			}
			File files[] = source.listFiles();

			for (int i = 0; i < files.length; i++) {
				System.out.println("Adding File: " + source.getParentFile().toURI().relativize(files[i].toURI()).getPath());
				FileInputStream fi = new FileInputStream(files[i]);
				origin = new BufferedInputStream(fi, BUFFER);

				/** Step: 3 ---> Create a zip entry for each file that is read. **/
				/**
				 * relativize is used to to add a file to a zip, without including the entire path from root.
				 **/
				ZipEntry entry = new ZipEntry(source.getParentFile().toURI().relativize(files[i].toURI()).getPath());

				/** Step: 4 ---> Put the zip entry using putNextEntry. **/
				out.putNextEntry(entry);

				/**
				 * Step: 5 ---> Write the data to the ZIP file and close the input stream.
				 **/
				int count;
				while ((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
			}

			/** Step: 6 --->close the output stream. **/
			out.close();
			System.out.println("Zip file created successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
