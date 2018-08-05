package collection.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByValue3 {
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

		// TreeMap<String, Integer> sortedMap = sortByValue(unSortedMap);
		Map sortedMap = sortByValue(unSortedMap);

		System.out.println(sortedMap);
		Iterator it = sortedMap.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = sortedMap.get(key);
			System.out.println("Key: " + key + " => " + sortedMap.get(key));
		}

	}

	public static Map sortByValue(Map unsortMap) {
		List list = new LinkedList(unsortMap.entrySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}

// class ValueComparator1 implements Comparator<String> {
//
// Map<String, Integer> map;
//
// public ValueComparator1(Map<String, Integer> base) {
// this.map = base;
// }
//
// public int compare(String a, String b) {
// if (map.get(a) >= map.get(b)) {
// return -1;
// } else {
// return 1;
// } // returning 0 would merge keys
// }
// }