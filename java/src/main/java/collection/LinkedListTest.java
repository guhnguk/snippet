package collection;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void test() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		
		int size = list.size();
		assertEquals(4, size);
		
		list.add(4);
		assertEquals(5, list.size());
		
		list.remove(3);
		assertEquals(4, list.size());

		assertTrue(list.contains(4));
		System.out.println(list.size());
		assertEquals(2, list.size());
	}

}
