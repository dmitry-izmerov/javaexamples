package ru.demi.java_examples.java_core.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author demi
 * @date 08.01.17
 */
public class SetExample {

	static class Entry {
		int id, value;

		Entry(int id, int value) {
			this.id = id;
			this.value = value;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Entry)) return false;
			return id == ((Entry) o).id;
		}

		public int hashCode() {
			return id;
		}

		public String toString() {
			return id + ":" + value;
		}
	}

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Entry(1, 1));
		list.add(new Entry(2, 2));
		list.add(new Entry(3, 3));
		list.add(new Entry(2, 4));
		list.remove(new Entry(3, 4));

		Set set = new HashSet(list);
		System.out.println(set);
		System.out.println(set.add(new Entry(1, 4)));
		set.remove(new Entry(2, 5));

		System.out.println(set);

        /*Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(1, 2);
        System.out.println(map);*/
	}
}
