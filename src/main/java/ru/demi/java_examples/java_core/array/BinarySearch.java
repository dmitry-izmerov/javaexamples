package ru.demi.java_examples.java_core.array;

import java.util.Arrays;

/**
 * Created by demi
 * on 16.06.15.
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] ar = {0, 10, 20, 30, 40, 50};
		int pos = Arrays.binarySearch(ar, 30);
		System.out.println(pos);

		// if searched element is not existing in current array
		// method return -(position + 1)
		System.out.println(Arrays.binarySearch(ar, 15));
		System.out.println(Arrays.binarySearch(ar, -10));
		System.out.println(Arrays.binarySearch(ar, 5));
	}
}
