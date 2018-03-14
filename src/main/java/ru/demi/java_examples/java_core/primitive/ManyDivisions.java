package ru.demi.java_examples.java_core.primitive;

/**
 * @author demi
 * @date 04.01.17
 */
public class ManyDivisions {
	public static void main(String[] args) {
		int myInt = 0;
		float myFloat = 0;
		try {
			float result = myFloat / myFloat;
			System.out.println(result);
		} catch (RuntimeException re) {
			System.out.println("Exception 1");
		}

		try {
			float result = myFloat / myInt;
			System.out.println(result);
		} catch (RuntimeException re) {
			System.out.println("Exception 2");
		}

		try {
			float result = myInt / myFloat;
			System.out.println(result);
		} catch (RuntimeException re) {
			System.out.println("Exception 3");
		}

		try {
			float result = myInt / myInt;
		} catch (RuntimeException re) {
			System.out.println("Exception 4");
		}
	}
}
