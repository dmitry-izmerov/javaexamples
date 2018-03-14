package ru.demi.java_examples.java_core.byte_operations;

/**
 * Created by demi
 * on 01.06.15.
 */
public class Main {
	public static void main(String[] args) {
		/**
		 * Exist next byte operations:
		 * | - OR
		 * & - AND
		 * ^ - XOR
		 * ~ - NOT
		 *
		 * << - bitwise left shift
		 * >> - bitwise right shift
		 * >>> - unsigned bitwise right shift
		 */
		System.out.println(8 | 4);
		System.out.println(12 & 6);
		System.out.println(0 ^ 1);
		System.out.println(~1);
		System.out.println(1 << 1);
		System.out.println(-2 >> 1);
		System.out.println(-2 >>> 1);

		// when quantity of shift equals quantity of bits
		// next shift return value to initial position
		int a = 1;
		for (int i = 0; i < 31; i++) {
			a <<= 1;
		}
		System.out.println(a);
		a <<= 1;
		System.out.println(a);
	}
}
