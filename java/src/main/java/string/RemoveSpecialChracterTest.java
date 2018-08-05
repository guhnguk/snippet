package string;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RemoveSpecialChracterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		String str = "klajdsfqpruipoieruqeiwojrqn34m0.12341230498019-23849[]\"";
		str = str.replaceAll(match, " ");
		System.out.println(str);
	}
}
