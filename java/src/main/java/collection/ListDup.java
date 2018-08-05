package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListDup {
	public static void main(String[] args) {
		String test = "a b c d e a b";

		String replaceAll = test.replaceAll("[\\W&&[^\\s]]", "");
		String[] words = replaceAll.split("\\W+");
		
		for (String word : words) {
			System.out.println(word);
		}
		System.out.println(words.length);
		System.out.println("------------------------------------------");
		List<String> words2 = Arrays.asList(words);
		for (String word : words2) {
			System.out.println(word);
		}
		System.out.println(words2.size());
		System.out.println("------------------------------------------");
		List<String> words3 = new ArrayList<String>();
		for (String word : words) {
			if (words3.contains(word)) {
				continue;
			}
			System.out.println(word);
			words3.add(word);
		}
		System.out.println(words3.size());
		System.out.println("------------------------------------------");
		Set<String> words4 = new TreeSet<String>();
		for (String word : words) {
			System.out.println(word);
			words4.add(word);
		}
		System.out.println(words4.size());
		System.out.println("------------------------------------------");
		
	}
}
