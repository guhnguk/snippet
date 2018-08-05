package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class SimpleSplitTest extends TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testSplit() throws Exception {
		List<String> values = new ArrayList<String>();
		String str1 = "term@documnet1\t14";
		String str2 = "term@documnet1\t24";
		String str3 = "term@documnet2\t34";
		String str4 = "term@documnet3\t44";
		String str5 = "term@documnet4\t54";
		
		values.add(str1);
		values.add(str2);
		values.add(str3);
		values.add(str4);
		values.add(str5);

		
		String[] split = str1.split("\t");
		String[] split2 = split[0].split("@");

		String key = split2[1];
		String val = split2[0] + "=" + split[1];
		System.out.println(key + "\t" + val);
		
		
		Map<String, Integer> tempCounter = new HashMap<String, Integer>();
		int sumOfWordsInDocument = 0;
		
		String[] wordCounter = val.split("=");
		tempCounter.put(wordCounter[0], Integer.valueOf(wordCounter[1]));
		sumOfWordsInDocument += Integer.parseInt(val.toString().split("=")[1]);

		System.out.println(sumOfWordsInDocument);
		
//		for (Text val : values) {
//			String[] wordCounter = val.toString().split("=");
//			tempCounter.put(wordCounter[0], Integer.valueOf(wordCounter[1]));
//			sumOfWordsInDocument += Integer.parseInt(val.toString().split("=")[1]);
//		}
//
//		for (String wordKey : tempCounter.keySet()) {
//			context.write(new Text(wordKey + "@" + key.toString()),
//					new Text(tempCounter.get(wordKey) + "/" + sumOfWordsInDocument));
//		}
	}
}
