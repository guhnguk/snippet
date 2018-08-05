package compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnZip2 {
	final static int BUFFER = 2048;

	/**
	 * Command line arguments : argv[0]-----> Source zip file. argv[1]-----> Destination directory.
	 **/
	public static void main(String argv[]) {
		try {

			/** create a ZipFile object. **/

			ZipFile zipfile = new ZipFile(argv[0]);

			ZipEntry entry;

			Enumeration e = zipfile.entries();

			/** Read the zip entries using the nextElement method **/

			while (e.hasMoreElements()) {

				entry = (ZipEntry) e.nextElement();

				System.out.println("Extracting: " + entry.getName());

				/** If the entry is a directory, create the directory. **/

				if (entry.isDirectory()) {

					File f = new File(argv[1] + entry.getName());
					f.mkdirs();
				}
				/**
				 * If the entry is a file,write the decompressed file to the disk.
				 **/
				else {
					int count;
					byte data[] = new byte[BUFFER];
					BufferedInputStream zis = new BufferedInputStream(zipfile.getInputStream(entry));

					FileOutputStream fos = new FileOutputStream(argv[1] + entry.getName());
					BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
					while ((count = zis.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, count);
					}

					/** close the input & output streams **/

					dest.close();
					zis.close();
				}
			}

			System.out.println("unzip completed successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}