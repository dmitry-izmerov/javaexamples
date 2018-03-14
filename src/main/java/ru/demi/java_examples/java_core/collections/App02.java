package ru.demi.java_examples.java_core.collections;

import java.util.LinkedHashMap;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by demi
 * on 09.07.15.
 */
public class App02 {
	public static void main(String[] args) {
		NavigableSet<String> set = new TreeSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		set.add("dd");
		set.add("ee");
		set.add("xx");
		System.out.println(set);

		NavigableSet<String> subset = set.tailSet("b", false);
		System.out.println(subset);
	}
}
