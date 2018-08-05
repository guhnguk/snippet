package string;

import org.junit.Test;

public class DelimeterTest {

	@Test
	public void test() {
		String strTest = "a,b,c,d,e";
		System.out.println("Before: " + strTest);
		strTest = strTest.replace(",", " ");
		System.out.println("After: " + strTest);
	}

}
