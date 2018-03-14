package ru.demi.java_examples.java_core.string;

/**
 * Created by demi
 * on 11.06.15.
 */
public class InternMethod {
	public static void main(String[] args) {
		String a = "string a";
		String b = new String("string a");
		String c = b.intern();

		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(a == c);
	}
}
