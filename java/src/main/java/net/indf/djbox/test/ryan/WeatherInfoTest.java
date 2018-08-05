package net.indf.djbox.test.ryan;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import net.indf.djbox.json.Djson;
import net.indf.djbox.json.Var;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Before;
import org.junit.Test;

public class WeatherInfoTest {
	private HttpClient client;

	@Before
	public void setUp() {
		client = new HttpClient();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJsonFile() {
		String date = "20121001";
		String latlon = "37.8,-122.4";

		String url = "http://api.wunderground.com/api/d958a6c10d900568/conditions/history_" + date + "/q/" + latlon
				+ ".json";

		PostMethod method = new PostMethod(url);

		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			int returnCode = client.executeMethod(method);
			if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
				System.err.println("The Post method is not implemented by this URI");
				method.getResponseBodyAsString();
			} else {
				br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
				sb = new StringBuffer(1024);
				String readLine;
				while (((readLine = br.readLine()) != null)) {
					sb.append(readLine);
				}

				// tistory.item.comments.comment[1].comment
				Var var = Djson.parse(sb.toString());
				Var find = var.find("response.current_observation.display_location.full");
				System.out.println(find);

				System.out.println(sb.toString());
				System.out.println(sb.length());

				// sb.setLength(0);
				// URL myUrl = new URL(url);
				// URLConnection conn = myUrl.openConnection();
				// InputStream is = conn.getInputStream();
				// br.close();
				// br = null;
				// br = new BufferedReader(new InputStreamReader(is));
				// char[] buff = new char[1024];
				// int len = -1;
				// while ((len = br.read(buff)) != -1) {
				// sb.append(new String(buff, 0, len) + "\n");
				// }
				// System.out.println(sb.toString());
				// System.out.println(sb.length());
			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			method.releaseConnection();
			if (br != null)
				try {
					br.close();
				} catch (Exception fe) {
				}
		}
	}

	@Test
	public void testParseJson() throws Exception {
		String filePath = "d:\\data\\37.8,-122.4.json";

		// BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		// StringBuffer sb = new StringBuffer(1024);
		// String readLine;
		// while ((readLine = br.readLine()) != null ) {
		// sb.append(readLine);
		// }

		Var var = Djson.parse(new File(filePath));
		Var displayLocationCity = var.find("current_observation.display_location.city");
		System.out.println(displayLocationCity);
		Var observationCity = var.find("current_observation.observation_location.city");
		System.out.println(observationCity);
		Var dateYear = var.find("history.date.year");
		System.out.println(dateYear);
		Var utcDateYear = var.find("history.utcdate.year");
		System.out.println(utcDateYear);
		Var observations = var.find("history.observations");
		System.out.println(observations.size());
		
		
		for (int i = 0, size = observations.size(); i < size; i++) {
			System.out.print(observations.get(i).get("date").find("year"));
			System.out.print(":"+ observations.get(i).get("date").find("mon"));
			System.out.print(":"+ observations.get(i).get("date").find("mday"));
			System.out.print(":"+ observations.get(i).get("date").find("hour"));
			System.out.println(":"+ observations.get(i).get("date").find("min"));
			
			System.out.println(observations.get(i).get("tempm"));
		}
		
		Var dailySummaryDateHour = var.find("history.dailysummary");
		System.out.println(dailySummaryDateHour.size());
		System.out.println(dailySummaryDateHour.get(0).get("date").get("hour"));
		System.out.println(dailySummaryDateHour.get(0).get("meanpressurei"));
		
	}
}
