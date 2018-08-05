package file.guava;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class GuavaFilesTest {

	@Test
	public void test() {
		String fileContents = "RYAN GO, JOEL GO\n";
		String targetDir = "d:/temp/guava/";
		
		File dir = new File(targetDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String fileName = "20131001_houry.csv";
		try {
			String fullPath = targetDir + fileName;
			File newFile = new File(fullPath);
			if (newFile.exists()) {
				Files.append(fileContents, newFile, Charsets.UTF_8);
				return;
			}
			Files.write(fileContents.getBytes(), newFile);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

}
