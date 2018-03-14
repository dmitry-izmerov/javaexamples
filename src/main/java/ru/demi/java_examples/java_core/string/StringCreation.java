package ru.demi.java_examples.java_core.string;

/**
 * @author demi
 * @date 21.05.16
 */
public class StringCreation {
	public static void main(String[] args) {
		System.out.println("123" == "123");
		System.out.println("123" == "1" + "23");
		System.out.println("123" == new String("123"));
	}
}
