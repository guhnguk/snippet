package type;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringTo {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String stringDouble = "0.822656617011107";
		Double parseDouble = Double.parseDouble(stringDouble);
		System.out.println(parseDouble);
	}

}
