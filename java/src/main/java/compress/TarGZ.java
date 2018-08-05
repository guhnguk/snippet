package compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

/**
 * Creating a tar.gz with apache commons-compress.
 **/
public class TarGZ {
	static final int BUFFER = 2048;

	/**
	 * Command line arguments : argv[0]-----> Source directory. argv[1]-----> Destination tar.gz file.
	 **/
	public static void main(String argv[]) {

		FileOutputStream fOut = null;
		BufferedOutputStream bOut = null;
		GzipCompressorOutputStream gzOut = null;
		TarArchiveOutputStream tOut = null;

		try {

			/** Step: 1 ---> create a TarArchiveOutputStream object. **/

			fOut = new FileOutputStream(new File(argv[1]));
			bOut = new BufferedOutputStream(fOut);
			gzOut = new GzipCompressorOutputStream(bOut);
			tOut = new TarArchiveOutputStream(gzOut);

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

				/** Step: 3 ---> Create a tar entry for each file that is read. **/

				/**
				 * relativize is used to to add a file to a tar, without including the entire path from root.
				 **/

				TarArchiveEntry entry = new TarArchiveEntry(files[i], source.getParentFile().toURI()
						.relativize(files[i].toURI()).getPath());

				/** Step: 4 ---> Put the tar entry using putArchiveEntry. **/

				tOut.putArchiveEntry(entry);

				/**
				 * Step: 5 ---> Write the data to the tar file and close the input stream.
				 **/

				FileInputStream fi = new FileInputStream(files[i]);
				BufferedInputStream sourceStream = new BufferedInputStream(fi, BUFFER);
				int count;
				byte data[] = new byte[BUFFER];
				while ((count = sourceStream.read(data, 0, BUFFER)) != -1) {
					tOut.write(data, 0, count);
				}
				sourceStream.close();

				/** Step: 6 --->close the archive entry. **/

				tOut.closeArchiveEntry();

			}
			/** Step: 7 --->close the output stream. **/

			tOut.close();
			System.out.println("tar.gz file created successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
