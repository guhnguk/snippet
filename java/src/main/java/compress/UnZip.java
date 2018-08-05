package compress;

import java.io.*;
import java.util.zip.*;

public class UnZip {
	final static int BUFFER = 2048;

	/**
	 * Command line arguments : argv[0]-----> Source zip file. argv[1]-----> Destination directory.
	 **/
	public static void main(String argv[]) {
		try {

			/** create a ZipInputStream object. **/

			FileInputStream fis = new FileInputStream(argv[0]);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));

			ZipEntry entry;

			/** Read the zip entries using the getNextEntry method **/

			while ((entry = zis.getNextEntry()) != null) {

				System.out.println("Extracting: " + entry.getName());

				/** If the entry is a directory, create the directory. **/

				if (entry.isDirectory()) {

					File f = new File(argv[1] + entry.getName());
					f.mkdirs();
				}
				/**
				 * If the entry is a file,write the decompressed file to the disk and close destination stream.
				 **/
				else {
					int count;
					byte data[] = new byte[BUFFER];

					FileOutputStream fos = new FileOutputStream(argv[1] + entry.getName());
					BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
					while ((count = zis.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, count);
					}
					dest.close();
				}
			}

			/** close the input stream **/

			zis.close();
			System.out.println("unzip completed successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
