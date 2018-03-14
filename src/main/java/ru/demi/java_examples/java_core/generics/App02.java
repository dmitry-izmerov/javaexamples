package ru.demi.java_examples.java_core.generics;

import java.util.ArrayList;

/**
 * Created by demi
 * on 06.07.15.
 */
public class App02 {
	public static void main(String[] args) {
		ArrayList<? extends Number> l1 = new ArrayList<>();
		ArrayList<? extends Integer> l2 = new ArrayList<>();

		l1 = l2;
		// !!! error
		// l2 = l1;
	}
}
