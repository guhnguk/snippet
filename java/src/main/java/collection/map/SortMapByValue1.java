package collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByValue1 {
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

		Map sortedMap = sortByValue(unSortedMap);
		System.out.println(sortedMap);

		Iterator it = sortedMap.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = sortedMap.get(key);
			System.out.println("Key: " + key + " => " + sortedMap.get(key));
		}
	}

	public static Map sortByValue(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
}

class ValueComparator implements Comparator {

	Map map;

	public ValueComparator(Map map) {
		this.map = map;
	}

	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}