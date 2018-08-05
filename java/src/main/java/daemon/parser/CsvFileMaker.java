package daemon.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvFileMaker implements Runnable {
	private final Logger log = LoggerFactory.getLogger(CsvFileMaker.class);

	private String filePath;
	private String targetFilePath;
	private List<Object> excludeHours;

	public CsvFileMaker(Configuration config, Object srcFilePath) {
		filePath = (String) srcFilePath;
		excludeHours = config.getList(ETLConstants.SOURCE_FILE_EXCLUDE_HOURS);
		targetFilePath = config.getString(ETLConstants.TARGET_FILE_PATH);
	}

	@Override
	public void run() {
		try {
			readFile();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	private void readFile() throws IOException {
		File rootFile = new File(filePath);
		File[] dir = rootFile.listFiles();

		if (dir == null) {
			log.info("The directory to read is nothing.");
			System.out.println("ETLDaemon exit");
			System.exit(0);
		}

		for (File dirDate : dir) {
			int fileCnt = 0;
			String dirName = dirDate.getName();
			log.info("Date dir name => " + dirName);

			File[] files = dirDate.listFiles();
			if (files != null && files.length > 0) {
				parseHourlyFile(files, dirName, ++fileCnt);
			}
		}
	}

	private void parseHourlyFile(File[] files, String parentFileName, int fileCnt) throws IOException {
		double totalReadCnt = 0;
		double writeCnt = 0;
		double contentSize = 0;

		BufferedReader br = null;
		BufferedWriter bw = null;
		String readLine = null;
		StringBuilder csvContent = new StringBuilder(1024);

		try {
			for (File file : files) {
				String hourName = file.getName();
				String targetDir = targetFilePath + parentFileName + "\\";
				String fileName = targetDir + hourName + ".csv";
				log.info("File name => " + fileName);
				
				log.info("#0 TEST");
				// if (excludeHours.contains(hourName)) {
				// continue;
				// }
				log.info("#1 TEST");
				bw = new BufferedWriter(new FileWriter(fileName));
				log.info("#2 TEST");
				if (file.isDirectory()) {
					File[] dataFiles = file.listFiles();
					for (File data : dataFiles) {
						br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "UTF-8"));
						while ((readLine = br.readLine()) != null) {
							totalReadCnt++;

							String date;
							String timezone;
							String dtValue;
							String peeripValue;
							try {
								String[] fullReadLine = readLine.split("\\xa7");
								if (!"ConnectionInit".equalsIgnoreCase(fullReadLine[5])) {
									log.debug("No found \"ConnectionInit\" => " + readLine);
									continue;
								}

								date = fullReadLine[4].substring(0, 11);
								timezone = fullReadLine[4].substring(12, fullReadLine[4].length());

								String[] body = fullReadLine[fullReadLine.length - 1].split("\\xb6");
								String[] dt = body[0].split("=");
								dtValue = dt[1];
								String[] peerip = body[1].split("=");
								peeripValue = peerip[1].split(":")[0];
								if (!peeripValue.contains(".")) {
									continue;
								}
							} catch (Exception e) {
								log.info("Read count => " + totalReadCnt);
								log.info("Read line problem! => " + readLine);
								log.error(e.getMessage(), e);
								continue;
							}

							csvContent.append(date).append(",").append(timezone).append(",");
							csvContent.append(dtValue).append(",");
							csvContent.append(peeripValue).append("\n");

							contentSize += csvContent.length();
							if (contentSize > ETLConstants.KByte) {
								bw.flush();
							}
							bw.write(csvContent.toString());
							writeCnt++;
							csvContent.setLength(0);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				bw.close();
				br.close();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		BigDecimal totalCount = new BigDecimal(totalReadCnt).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal writePercent = new BigDecimal(writeCnt / totalReadCnt * 100).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal skipPercent = new BigDecimal((totalReadCnt - writeCnt) / totalReadCnt * 100).setScale(2,
				BigDecimal.ROUND_HALF_UP);

		log.info("Total cnt => " + totalCount);
		log.info("Write cnt => {}({}%)", writeCnt, writePercent);
		log.info("Skip cnt => {}({}%)", (totalReadCnt - writeCnt), skipPercent);
	}
}
