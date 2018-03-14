package ru.demi.java_examples.java_core.byte_operations;

/**
 * Created by demi
 * on 01.06.15.
 */
public class Swap {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		x = x ^ y; // 01 ^ 10 = 11
		y = y ^ x; // 10 ^ 11 = 01
		x = x ^ y; // 11 ^ 01 = 10
		System.out.printf("a - %d, b - %d%n", x, y);
	}
}
