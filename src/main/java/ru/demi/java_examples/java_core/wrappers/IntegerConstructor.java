package ru.demi.java_examples.java_core.wrappers;

/**
 * @author demi
 * @date 15.01.17
 */
public class IntegerConstructor {
	public static void main(String... args) {
		Integer i1 = new Integer("013"); // 13
		Integer i2 = new Integer(013);   // 11
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));

		System.out.println(013);
		System.out.println(0x13);
		System.out.println(0b11);
	}
}
