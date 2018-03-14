package ru.demi.java_examples.java_core.collections;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by demi
 * on 09.07.15.
 */
public class App01 {
	public static void main(String[] args) {
		NavigableSet<String> set = new TreeSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
		set.add("f");
		System.out.println(set);

		NavigableSet<String> subset = set.subSet("b", true, "e", false);
		System.out.println(subset);
	}
}
