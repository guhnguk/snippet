package string;

import static org.junit.Assert.*;

import java.lang.Character.UnicodeBlock;

import org.junit.Test;

public class TestCheckHangul {
	@Test
	public void testContainsHangul() {
		assertFalse(isHangul("abc"));
		assertTrue(isHangul("한"));
		assertTrue(isHangul("한글"));
		assertTrue(isHangul("한abc"));
		assertTrue(isHangul("한abc글"));
		assertTrue(isHangul("ab한c"));
		assertTrue(isHangul("a한b글c테d스e트f"));
		assertFalse(isHangul("123abc"));
		assertFalse(isHangul("123"));
		assertTrue(isHangul("한123"));
		assertFalse(isHangul("a1b2c3d4"));
		assertTrue(isHangul("a1b2한글c3d4"));
		assertFalse(isHangul("にほんご"));
		assertFalse(isHangul("日本語"));
	}

	public boolean isHangul(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(ch);
			if (UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)
					|| UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock)
					|| UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock))
				return true;
		}
		return false;
	}

}
