package ru.demi.java_examples.java_core.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author demi
 * @date 08.01.17
 */
public class ArraysExample {
	public static void main(String[] args) {
		String[] slist = {"Ted", "Bill", "Jack", "Roy", "Adam", "Stan"};
		List list = Arrays.asList(slist);
		list.set(4, "Mark");
		slist[2] = "David";

		for (String s : slist) {
			System.out.print(s + " ");
		}
	}
}
