package configuration;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import daemon.parser.ETLConstants;

public class Configurer {
	private final Logger logger = LoggerFactory.getLogger(Configurer.class);

	private static String srcDir;
	private String countryType;
	private String targetDir;
	private static Properties config;

	static {
		try {
			config = new Properties();
			FileInputStream fis = new FileInputStream(ETLConstants.CONFIG_PROPERTIES);
			config.load(new BufferedInputStream(fis));
			fis.close();
		} catch (IOException e) {
		}
	}

	public Configurer() {
		srcDir = config.getProperty(ETLConstants.SOURCE_FILE_PATH).trim();
		targetDir = config.getProperty(ETLConstants.TARGET_FILE_PATH).trim();
	}

	public static void main(String[] args) {
		System.out.println(srcDir);
	}

	// public void execute() throws IOException {
	// if ("usa".equals(countryType)) {
	// ExecutorService ex = Executors.newFixedThreadPool(3);
	// String[] srcFilePaths = srcDir.split(",");
	// for (int i = 0, size = srcFilePaths.length; i < size; i++) {
	// ex.execute(new CsvFileMaker(config, srcFilePaths[i]));
	// }
	//
	// ex.shutdown();
	// while(!ex.isTerminated()){
	// try {
	// TimeUnit.SECONDS.sleep(1);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }

	private void deleteTarget() throws IOException {
		File targetFile = new File(targetDir);
		deleteDirectory(targetFile);

		// execute();
	}

	private void deleteDirectory(File targetFile) {
		if (!targetFile.exists()) {
			logger.info("Target file not exist.");
			return;
		}

		File[] files = targetFile.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				deleteDirectory(file);
			} else {
				logger.debug("File delete start.");
				file.delete();
			}
		}
	}
}
