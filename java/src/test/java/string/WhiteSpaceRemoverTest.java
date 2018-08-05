package string;

import junit.framework.TestCase;

import org.junit.Test;

public class WhiteSpaceRemoverTest extends TestCase {
	@Test
	public void testShowStringInfo() throws Exception {
		String myString = " ABC DEF GH ";
		WhiteSpaceRemover.showStringInfo(myString);

		String removeString1 = myString.replaceAll(" ", "");
		WhiteSpaceRemover.showStringInfo(removeString1);

		// Next code is better to remove whitespace
		String removeString2 = myString.replaceAll("\\p{Z}", "");
		WhiteSpaceRemover.showStringInfo(removeString2);

		// right-left trim
		String removeString3 = myString.replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
		WhiteSpaceRemover.showStringInfo(removeString3);
	}
}
