package daemon.parser;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ETLDaemon {
	private static Configuration config;

	public static void main(String[] args) {
		try {
			new ETLDaemon().execute();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	private List<Object> srcFilePath;

	private void execute() {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0, size = srcFilePath.size(); i < size; i++) {
			executor.execute(new CsvFileMaker(config, srcFilePath.get(i)));
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private ETLDaemon() throws ConfigurationException {
		config = new PropertiesConfiguration(ETLConstants.CONFIG_PROPERTIES);
		srcFilePath = config.getList(ETLConstants.SOURCE_FILE_PATH);
	}
}
