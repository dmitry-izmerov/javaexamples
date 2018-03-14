package ru.demi.java_examples.java_core.string;

/**
 * Created by demi
 * on 11.06.15.
 */
public class StringPool {
	public static void main(String[] args) {
		String s1 = "Cat";
		String s2 = "Cat";
		String s3 = new String("Cat");

		// check does new String() pass the created object to strings pool?
		String s4 = new String("string");
		String s5 = "string";
		String s6 = "string";

		System.out.println("s1 == s2 : " + (s1 == s2));
		System.out.println("s1 == s3 : " + (s1 == s3));
		System.out.println("s4 == s5 : " + (s4 == s5));
		System.out.println("s5 == s6 : " + (s5 == s6));


	}
}
