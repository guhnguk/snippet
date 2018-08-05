package collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByValue2 {
	public static void main(String[] args) {
		HashMap<String, Integer> unSortedMap = new HashMap<String, Integer>();
		unSortedMap.put("a", 10);
		unSortedMap.put("b", 30);
		unSortedMap.put("c", 50);
		unSortedMap.put("d", 40);
		unSortedMap.put("e", 20);

		System.out.println(unSortedMap);
		for (String key : unSortedMap.keySet()) {
			System.out.println("Key: " + key + " => " + unSortedMap.get(key));
		}

		TreeMap<String, Integer> sortedMap = SortByValue(unSortedMap);

		System.out.println(sortedMap);
		for (String key : sortedMap.keySet()) {
			System.out.println("Key: " + key + " => " + sortedMap.get(key));
		}

	}

	public static TreeMap<String, Integer> SortByValue(HashMap<String, Integer> map) {
		ValueComparator1 vc = new ValueComparator1(map);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
}

class ValueComparator1 implements Comparator<String> {

	Map<String, Integer> map;

	public ValueComparator1(Map<String, Integer> base) {
		this.map = base;
	}

	public int compare(String a, String b) {
		if (map.get(a) >= map.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}