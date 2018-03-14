package ru.demi.java_examples.java_core.array;

import java.util.Arrays;

/**
 * Created by demi
 * on 12.06.15.
 */
public class ArrayInverter {
	public static <T> T[] invert(T[] ar) {
		for (int i = 0, length = ar.length; i < length / 2; i++) {
			T tmp = ar[i];
			ar[i] = ar[length - 1 - i];
			ar[length - 1 - i] = tmp;
		}
		return ar;
	}

	public static <T> T[] invertRec(T[] ar, int i) {
		if (i < ar.length / 2) {
			T tmp = ar[i];
			ar[i] = ar[ar.length - 1 - i];
			ar[ar.length - 1 - i] = tmp;
			invertRec(ar, i + 1);
		}
		return ar;
	}

	public static void main(String[] args) {
		Integer[] ar = new Integer[]{1, 2, 3};
		System.out.println(Arrays.toString(invertRec(ar, 0)));
	}
}
