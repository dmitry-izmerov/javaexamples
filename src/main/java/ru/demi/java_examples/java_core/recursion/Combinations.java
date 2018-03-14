package ru.demi.java_examples.java_core.recursion;

import java.util.Arrays;

/**
 * Created by demi
 * on 20.06.15.
 */
public class Combinations {
	public static void main(String[] args) {
		combine(new int[]{1, 2, 3}, 3);
	}

	/**
	 * Print all possible combinations for array
	 *
	 * @param ar
	 * @param size
	 */
	public static void combine(int[] ar, int size) {
		if (size < 2) {
			System.out.println(Arrays.toString(ar));
		} else {
			for (int i = 0; i < size; i++) {
				swap(ar, size);
				combine(ar, size - 1);
			}
		}
	}

	public static int[] swap(int[] ar, int size) {
		//int[] res = Arrays.copyOf(ar, ar.length);
		for (int i = 0; i < size - 1; i++) {
			int tmp = ar[i];
			ar[i] = ar[i + 1];
			ar[i + 1] = tmp;
		}
		return ar;
	}
}
