package file.csv;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import au.com.bytecode.opencsv.CSVWriter;

public class OpenCsvTest {

	@Test
	public void test() {
		try {
			String file = "37.8,-122.4,US,California,Financial District, San Francisco,37.793579,-122.399330,100 ft,KCASANFR102,2013-10-25 01:23,America/Los_Angeles,2013-10-25 08:23,UTC,11.0,51.8,9.0,48.2,88,13.0,8.1,-9999.0,-9999.0,280,West,16.1,10.0,1020.2,30.13,-999,-999,-9999,-9999,-9999.00,-9999.00,Mostly Cloudy,0,0,0,0,0,0";
			CSVWriter writer = new CSVWriter(new FileWriter("d:\\data\\yourfile.csv"), ',');
			// feed in your array (or convert your data to an array)
			String[] entries = file.split(","); //"first#second#third".split("#");
			writer.writeNext(entries);
			writer.close();
		} catch (IOException e) {
			fail(e.getMessage());
		}

	}

}
