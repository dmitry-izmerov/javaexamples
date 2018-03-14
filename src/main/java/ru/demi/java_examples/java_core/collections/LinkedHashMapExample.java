package ru.demi.java_examples.java_core.collections;

import java.util.LinkedHashMap;

/**
 * @author demi
 * @date 06.01.17
 */
public class LinkedHashMapExample {

	public static void main(String[] args) {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("1", "1");
		map.put("55", "55");
		map.put("44", "44");
		map.put("66", "66");
		System.out.println("Access order: false");
		map.forEach((k, v) -> System.out.println(k + " = " + v));
		System.out.println();

		LinkedHashMap<String, String> mapWithAccessOrder = new LinkedHashMap<>(16, 0.75f, true);
		mapWithAccessOrder.put("1", "1");
		mapWithAccessOrder.put("55", "55");
		mapWithAccessOrder.put("44", "44");
		mapWithAccessOrder.put("66", "66");

		mapWithAccessOrder.get("1");
		mapWithAccessOrder.get("55");

		System.out.println("Access order: true");
		mapWithAccessOrder.forEach((k, v) -> System.out.println(k + " = " + v));
		System.out.println();
	}
}
