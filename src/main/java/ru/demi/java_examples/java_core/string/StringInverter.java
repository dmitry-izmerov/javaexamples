package ru.demi.java_examples.java_core.string;

/**
 * Created by demi
 * on 13.06.15.
 */
public class StringInverter {
	public static String invert(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0, l = chars.length; i < l / 2; i++) {
			char tmp = chars[i];
			chars[i] = chars[l - 1 - i];
			chars[l - 1 - i] = tmp;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		String s = "abcd";
		System.out.print(s);
		System.out.print(" -> ");
		s = invert(s);
		System.out.print(s);
	}
}
