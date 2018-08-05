package string;

public class WhiteSpaceRemover {

	public static void main(String[] args) {
		String myString = " ABC DEF GH ";
		showStringInfo(myString);

		String removeString1 = myString.replaceAll(" ", "");
		showStringInfo(removeString1);

		// Next code is better to remove whitespace
		String removeString2 = myString.replaceAll("\\p{Z}", "");
		showStringInfo(removeString2);
		
		// right-left trim
		String removeString3 = myString.replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
		showStringInfo(removeString3);
	}

	public static void showStringInfo(String myString) {
		System.out.println("String Length: " + myString.length());
		System.out.println("String Literal: " + myString);
		int whitespace_len = myString.length() - myString.replaceAll(" ", "").length();
		System.out.println("Whitespace Count: " + whitespace_len);
		System.out.println("-----------------------------");
    }

}
