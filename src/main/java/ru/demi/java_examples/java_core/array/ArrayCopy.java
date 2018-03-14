package ru.demi.java_examples.java_core.array;

import java.util.Arrays;

/**
 * Created by demi
 * on 16.06.15.
 */
public class ArrayCopy {
	public static void main(String[] args) {
		int[] ar1 = {1, 2, 3, 4, 5};
		int[] ar2 = new int[10];

		System.arraycopy(ar1, 2, ar2, 0, 3);
		System.out.println("ar2: " + Arrays.toString(ar2));

		int[] ar3 = {1, 2, 3, 4, 0, 0};
		System.arraycopy(ar3, 0, ar3, 1, 4);
		System.out.println("ar3: " + Arrays.toString(ar3));
	}
}
