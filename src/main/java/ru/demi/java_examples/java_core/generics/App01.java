package ru.demi.java_examples.java_core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 06.07.15.
 */
public class App01 {
	public static void main(String[] args) {
		// нековариантые
		// !!! error
		// ArrayList<Number> l1 = new ArrayList<Integer>();
		// ковариантные
		// доступен только для чтения!!!
		ArrayList<? extends Number> l2 = new ArrayList<>();
		// !!! error
		// l2.add(new Integer(2));

		// lower bound
		ArrayList<? super Number> l3 = new ArrayList<>();
		l3.add(1);
		System.out.println(l3.get(0));
	}

	/**
	 * You can pass one class or several interfaces to right from extends expression
	 */
	public static <T extends Number & Comparable<T> & List<T>> T getValue(T v) {
		return v;
	}
}
