package ru.demi.java_examples.different_tricks;

import java.util.HashSet;
import java.util.Set;

/**
 * @author demi
 * @date 21.12.16
 */
public class SetRemoveAndShortType {
	public static void main(String[] args) {
		Set<Short> set = new HashSet<Short>();
		for (short i = 0; i < 100; i++) {
			set.add(i);
			set.remove((short) (i - 1));
		}
		System.out.println(set);
	}
}
