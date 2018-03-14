package ru.demi.java_examples.java_core.oop;

/**
 * @author demi
 * @date 12.01.17
 */
public class OverloadStaticMethod {
	public static void main(String[] X) {
		print(new int[]{1, 2, 3, 4});
		print(new Long[]{1l, 2l, 3l, 4l});
	}

	static void print(Long i) {
		System.out.print(1);
	}

	static void print(Object i) {
		System.out.print(2);
	}

	static void print(Object... i) {
		System.out.print(3);
	}

	static void print(long[] i) {
		System.out.print(4);
	}

	static void print(Integer... i) {
		System.out.print(5);
	}

	static void print(Number... i) {
		System.out.print(6);
	}
}
