package daemon.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Files;

public class CsvFileMakerRecursive implements Runnable {
	private final Logger logger = LoggerFactory.getLogger(CsvFileMakerRecursive.class);

	private String sourceFilePath;
	private String threadIdx;
	private String targetDir;
	private String targetFileName;
	private String nodeName;
	private String folderType;
	private long fileSize;
	private String fileUnit;

	/**
	 * @param config
	 * @param sourceFilePath
	 */
	public CsvFileMakerRecursive(Properties config, String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;

//		this.folderType = config.getProperty(ETLConstants.SOURCE_FILE_TYPE).trim();
//		this.nodeName = config.getProperty(ETLConstants.NCLUSTER_NODE_NAME).trim();
//		this.targetFileName = config.getProperty(ETLConstants.TARGET_FILE_NAME).trim();
		this.targetDir = config.getProperty(ETLConstants.TARGET_FILE_PATH).trim();
		this.targetDir = targetDir.endsWith("/") ? targetDir : targetDir + "/";
//		this.fileSize = Integer.parseInt(config.getProperty(ETLConstants.TARGET_FILE_SIZE));
//		this.fileUnit = config.getProperty(ETLConstants.TARGET_FILE_UNIT).trim();

		if (this.fileUnit.equalsIgnoreCase(ETLConstants.KB)) {
			this.fileSize = this.fileSize * ETLConstants.KByte;
		} else if (this.fileUnit.equalsIgnoreCase(ETLConstants.MB)) {
			fileSize = this.fileSize * ETLConstants.MByte;
		} else if (this.fileUnit.equalsIgnoreCase(ETLConstants.GB)) {
			this.fileSize = this.fileSize * ETLConstants.GByte;
		}
		threadIdx = this.sourceFilePath.substring(sourceFilePath.length() - 1, sourceFilePath.length());
	}

	@Override
	public void run() {
		File rootFile = new File(sourceFilePath);
		try {
			makeCsv(rootFile);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void makeCsv(File rootFile) throws IOException {
		File[] dirs = rootFile.listFiles();
		if (null == dirs) {
			return;
		}

		int fileCnt = 0;
		long contentSize = 0;
		
		int dirLength = dirs.length;

		String padStart = Strings.padStart(String.valueOf(++fileCnt), String.valueOf(100000).length(), '0');
		String makeFileName = targetDir + targetFileName + nodeName + "_" + threadIdx + "_" + padStart + ".csv";

		if (!new File(targetDir).exists()) {
			Files.createParentDirs(new File(makeFileName));
		}

		int csvFileCnt = 0;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(makeFileName));// , (int) (100 * ETLConstants.KByte));
		for (File dir : dirs) {
			String dirName = dir.getName();

			if (dirName.contains(folderType) && dir.isDirectory()) {
				String[] splitFileName = dirName.split("_");

				String vinId = splitFileName[1];
				String trTransferDate = splitFileName[2];

				StringBuffer csvContent = new StringBuffer();
				String fileName = null;
				File[] files = dir.listFiles();

				for (File file : files) {
					fileName = file.getName();

					if (file.isDirectory()) {
						logger.debug("[" + file.getParent() + "/" + fileName + "] This is file is direcotry. Ooops !!");
						continue;
					}
					String fileType = fileName.substring(0, fileName.lastIndexOf("."));
					String hexData = Files.readFirstLine(file, Charsets.UTF_8);

					csvContent.append(vinId).append(',').append(trTransferDate).append(',').append(fileType).append(',').append(hexData).append("\n");

				}

				contentSize += csvContent.length();

				if (contentSize > fileSize) {
					bw.flush();
					bw.close();

					contentSize = 0;
					csvContent.setLength(0);

					padStart = Strings.padStart(String.valueOf(++fileCnt), String.valueOf(100000).length(), '0');
					makeFileName = targetDir + targetFileName + nodeName + "_" + threadIdx + "_" + padStart + ".csv";

					bw = new BufferedWriter(new FileWriter(makeFileName));// , (int) (100 * ETLConstants.KByte));
					
					csvFileCnt++;
				}

				if (contentSize > ETLConstants.MByte) {
					bw.flush();
				}
				bw.write(csvContent.toString());

			} else {
				makeCsv(dir);
			}
		}
		
		//bw.write(csvContent.toString());
		bw.close();
		csvFileCnt++;
		logger.info("Thread-"+ threadIdx + "'s directory count => " + dirLength);
		logger.info("Thread-"+ threadIdx + "'s csv file count => " + csvFileCnt);
	}
}
