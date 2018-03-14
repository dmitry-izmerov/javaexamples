package ru.demi.java_examples.java_core.byte_operations;

/**
 * Created by demi
 * on 01.06.15.
 */
public class SecondPower {
	public static void main(String[] args) {
		// how to check that has the number power of two?
		int a = 1;
		int b = 2;
		int c = 3;
		System.out.println(isPowerOfTwo(a));
		System.out.println(isPowerOfTwo(b));
		System.out.println(isPowerOfTwo(c));
	}

	public static boolean isPowerOfTwo(int n) {
		return (n != 0) && (n & (n - 1)) == 0;
	}
}


