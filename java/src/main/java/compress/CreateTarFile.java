package compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class CreateTarFile {
	public static void main(String[] args) {
	}

	private static File createTarFile(String[] filePaths, String saveAs) throws Exception {
		File tarFile = new File(saveAs);
		OutputStream out = new FileOutputStream(tarFile);

		TarArchiveOutputStream aos = (TarArchiveOutputStream) new ArchiveStreamFactory().createArchiveOutputStream("tar",
				out);

		for (String filePath : filePaths) {
			File file = new File(filePath);
			TarArchiveEntry entry = new TarArchiveEntry(file);
			entry.setSize(file.length());
			aos.putArchiveEntry(entry);
			IOUtils.copy(new FileInputStream(file), aos);
			aos.closeArchiveEntry();
		}
		aos.finish();
		aos.close();
		out.close();

		return tarFile;
	}
}
