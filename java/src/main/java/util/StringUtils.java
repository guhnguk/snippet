package util;

import java.util.Random;

/**
 * 
 * @author Ryan Ahn
 *
 */
public class StringUtils {
	private StringUtils() {
	}

	/**
	 * 문자열(String)의 첫번째 문자를 대문자로 변환한다.
	 * 
	 * <pre>
	 * StringUtils.capitalize(null)  = null
	 * StringUtils.capitalize("Han") = "Han"
	 * StringUtils.capitalize("han") = "Han"
	 * </pre>
	 * 
	 * @param str
	 *            문자열
	 * @return 첫번째 문자를 대문자로 변환한 문자열
	 */
	public static String toUppercaseFirstCh(String str) {
		if (str == null) {
			return null;
		}
		char[] charArray = str.toCharArray();
		if (charArray.length > 0) {
			charArray[0] = Character.toUpperCase(charArray[0]);
		}
		return new String(charArray);
	}

	/**
	 * 문자열(String)의 첫번째 문자를 소문자로 변환한다.
	 * 
	 * <pre>
	 * StringUtils.uncapitalize(null)  = null
	 * StringUtils.uncapitalize("han") = "han"
	 * StringUtils.uncapitalize("HAN") = "hAN"
	 * </pre>
	 * 
	 * @param str
	 *            문자열
	 * @return 첫번째 문자를 대문자로 변환한 문자열
	 */
	public static String toLowerFirstCh(String param) {
		if (!isEmpty(param)) {
			return param.substring(0, 1).toLowerCase() + param.substring(1, param.length());
		}

		return null;
	}

	/**
	 * <p>
	 * 문자열(String)이 공백("")이거나 <code>null</code>인 검사한다.
	 * </p>
	 * 
	 * <pre>
	 * StringHandler.isEmpty(null)    = true
	 * StringHandler.isEmpty("")      = true
	 * StringHandler.isEmpty("   ")   = false
	 * StringHandler.isEmpty("han")   = false
	 * StringHandler.isEmpty(" han ") = false
	 * </pre>
	 * 
	 * 
	 * @param str
	 *            검사할 문자열
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 
	 * @param seed
	 * @return
	 */
	public static String getCharacters(int seed) {
		char ch[] = { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
				'U', 'V', 'W', 'X', 'Y', 'Z',
				
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
				'u', 'v', 'w', 'x', 'y', 'Z'

		};

		Random rand = new Random();
		String str = "";

		StringBuffer sb = new StringBuffer(128);

		for (int j = 0; j < seed; j++) {
			for (int k = 0; k < 1; k++) {
				sb.append(ch[rand.nextInt(36)]);
			}
		}

		str = sb.toString();
		return str;
	}

	public static String getCharacters(byte[] buf) {
		Random rand = new Random();
		int size = 0;
		int bufSize = buf.length;
		while (true) {
			if (size >= bufSize) {
				break;
			}

			int n = rand.nextInt(122);

			n += '0';
			if (('0' <= n && n <= '9') || ('A' <= n && n <= 'Z') || ('a' <= n && n <= 'z')) {
				buf[size] = (byte) n;
			} else {
				continue;
			}

			size++;
		}

		return new String(buf);
	}
}
