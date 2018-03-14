package ru.demi.java_examples.java_core.generics;

import java.util.ArrayList;

/**
 * Created by demi
 * on 06.07.15.
 */
public class App03 {
	public static void main(String[] args) {
		ArrayList<? super Number> l1 = new ArrayList<Number>();
		ArrayList<? super Integer> l2 = new ArrayList<Integer>();

		// !!! error
		// l1 = l2;
		l2 = l1;
	}
}
