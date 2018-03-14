package ru.demi.java_examples.java_core.charset;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/**
 * Created by demi
 * on 05.07.15.
 */
public class AllCharsets {
	public static void main(String[] args) {
		Map<String, Charset> allCharsets = Charset.availableCharsets();
		Set<String> charsetNames = allCharsets.keySet();
		System.out.println(charsetNames);
		System.out.println(charsetNames.size());
	}
}
