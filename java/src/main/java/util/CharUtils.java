package util;

public class CharUtils {
	public static int char2Ascii(final char character) {
		return (int) character;
	}

	public static char ascii2char(final int ascii) {
		return (char) ascii;
	}

	public static void main(String[] args) {
		System.out.println(CharUtils.ascii2char(167));
		System.out.println(CharUtils.ascii2char(182));
		
		
		// 문자를 아스키 코드 (10진수) 로 변환 출력
	    System.out.println((int) 'A'); // 65
	    // 문자를 유니코드 코드 (10진수) 로 변환 출력
	    System.out.println((int) '가'); // 44032
	    // 문자를 아스키 코드 (16진수) 로 변환 출력
	    System.out.format("0x%02X%n", (int) 'A'); // 0x41
	    // 문자를 유니코드 코드 (16진수) 로 변환 출력
	    System.out.format("0x%04X%n", (int) '가'); // 0xAC00

	    // 코드 번호를 문자로 변환 출력
	    System.out.println((char) 65); // A
	    System.out.println((char) 0x41); // A (이것은 16진수로 'A'를 출력한 예제)
	    // 코드 번호를 문자로 변환 출력 (한글)
	    System.out.println((char) 0xAC00); // 가
	    
	    String s = String.format("0x%02X%n", (int) 'A');
	    System.out.println(s); // 0x41
	}
}