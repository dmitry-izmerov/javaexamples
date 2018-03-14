package ru.demi.java_examples.java_core.charset;

import java.util.Arrays;

/**
 * Created by demi
 * on 05.07.15.
 */
public class App01 {
	public static void main(String[] args) {
		testCodePoint(65);
		testCodePoint(10_000);
		testCodePoint(50_000);
		testCodePoint(165_535);
	}

	public static void testCodePoint(int codePoint) {
		char[] chars = Character.toChars(codePoint);
		System.out.println("char[]: " + Arrays.toString(chars));
		String s = new String(chars);
		System.out.println("Sring: " + s);
		System.out.println("String length: " + s.length());
		System.out.println("String.codePoint:" + s.codePointCount(0, s.length()));
		System.out.println();
	}
}
