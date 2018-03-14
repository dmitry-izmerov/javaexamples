package ru.demi.java_examples.java_core.string;

/**
 * Created by demi
 * on 11.06.15.
 */
public class Similarity {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc"; // using strings pool!
		String s3 = new String("abc");
		System.out.println("s1 == s2 ? " + (s1 == s2)); // true
		System.out.println("s1 == s3 ? " + (s1 == s3)); // false
		System.out.println("s1 equals s3 ? " + (s1.equals(s3))); // true
	}
}
