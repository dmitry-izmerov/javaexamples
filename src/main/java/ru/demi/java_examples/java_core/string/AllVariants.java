package ru.demi.java_examples.java_core.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by demi
 * on 11.06.15.
 */
public class AllVariants {
	public static Set<String> findPermutation(String str) {
		Set<String> permSet = new HashSet<>();

		// Handle error
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			permSet.add("");
			return permSet;
		}

		char initial = str.charAt(0);
		String rest = str.substring(1);
		Set<String> words = findPermutation(rest);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				permSet.add(insertChar(word, initial, i));
			}
		}
		return permSet;
	}

	public static String insertChar(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	public static void main(String[] args) {
		String s = "AAC";
		String s1 = "ABC";
		String s2 = "ABCD";
		System.out.println("\nPermutations for " + s + " are: \n" + findPermutation(s));
		System.out.println("\nPermutations for " + s1 + " are: \n" + findPermutation(s1));
		System.out.println("\nPermutations for " + s2 + " are: \n" + findPermutation(s2));
	}
}
