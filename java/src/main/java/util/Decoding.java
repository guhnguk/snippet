package util;

import org.apache.commons.codec.binary.Base64;

public class Decoding {
	/**
	 * Performs base64-decoding of input bytes.
	 * 
	 * @param rawData
	 *          * Array of bytes to be encoded.
	 * @return * The base64 decoded string representation of rawData.
	 */
	public static String decodeBase64(byte[] rawData) {
		return new String(Base64.decodeBase64(rawData)).trim();
	}
}