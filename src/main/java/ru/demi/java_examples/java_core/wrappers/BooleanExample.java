package ru.demi.java_examples.java_core.wrappers;

/**
 * @author demi
 * @date 07.01.17
 */
public class BooleanExample {
	public static void main(String[] args) {
		Boolean b1 = new Boolean("true");
		System.out.println(b1);
		b1 = new Boolean("tRuE");
		System.out.println(b1);
		b1 = new Boolean("test");
		System.out.println(b1);
		b1 = new Boolean(true);
		System.out.println(b1);
		b1 = true;
		System.out.println(b1);
	}
}
