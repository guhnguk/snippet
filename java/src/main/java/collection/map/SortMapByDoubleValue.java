package collection.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByDoubleValue {
	public static void main(String[] args) {

		Map<String, Double> unsortMap = new TreeMap<String, Double>();
		unsortMap.put("A", 99.5);
		unsortMap.put("B", 67.4);
		unsortMap.put("C", 67.3);
		unsortMap.put("D", 67.4);

		System.out.println("Unsort Map......");
		printMap(unsortMap);

		System.out.println("\nSorted Map......");
		Map<String, Double> sortedMap = sortByComparator(unsortMap);
		printMap(sortedMap);

	}

	private static Map<String, Double> sortByComparator(Map<String, Double> unsortMap) {

		// Convert Map to List
		List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Collections.reverse(list);

		// Convert sorted map back to a Map
		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
		for (Iterator<Map.Entry<String, Double>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Double> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	public static void printMap(Map<String, Double> map) {
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
		}
	}
}
