package collection.map;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

public class AddOhterMap {

	public static void main(String[] args) {
		// Create some maps
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "Hello");
		map1.put(2, "There");

		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(2, "It");
		map2.put(3, "is");
		map2.put(4, "a");
		map2.put(5, "bird");

		// google guava
		// Add everything in map1 not in map2 to map2
		map2.putAll(Maps.difference(map1, map2).entriesOnlyOnLeft());
		for (Integer key : map2.keySet()) {
			String value = map2.get(key);
			System.out.println("Key: " + key + " => " + "Value: " + value);
		}

		System.out.println("=======================================================");

		map2.putAll(map1);
		for (Integer key : map2.keySet()) {
			String value = map2.get(key);
			System.out.println("Key: " + key + " => " + "Value: " + value);
		}
		
		System.out.println("=======================================================");
		
		map1.putAll(map2);
		for (Integer key : map1.keySet()) {
			String value = map1.get(key);
			System.out.println("Key: " + key + " => " + "Value: " + value);
		}
	}

}
