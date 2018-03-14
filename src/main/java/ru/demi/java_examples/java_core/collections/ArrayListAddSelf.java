package ru.demi.java_examples.java_core.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author demi
 * @date 14.01.17
 */
public class ArrayListAddSelf {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add("some object");
		list.add(list);

		list.forEach(System.out::println);
	}
}



