package ru.demi.java_examples.java_core.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author demi
 * @date 14.01.17
 */
public class ArrayListIndexOutOfBoundsException {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		for (int i = 0; i < list.size(); i++) {
			int e = list.get(i);
			list.remove(e);
		}

		System.out.println(list.size());
	}
}
