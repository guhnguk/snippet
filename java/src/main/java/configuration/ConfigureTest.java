package configuration;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class ConfigureTest {
	private static Properties config;

	static {
		try {
			config = new Properties();
			FileInputStream fis = new FileInputStream(Contants.CONFIG_PROPERTIES);
			config.load(new BufferedInputStream(fis));
			fis.close();
		} catch (IOException e) {
		}
	}

	@Test
	public void test() {
		System.out.println("TEST");
		
		String number = config.getProperty(Contants.KEY_CHOICE_NUMBER);
		String[] property = config.getProperty(Contants.KEY_SET + number ).split(",");
		for (String str: property) {
			System.out.println(str);
		}
	}

}
