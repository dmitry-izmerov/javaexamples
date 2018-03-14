package ru.demi.java_examples.java_core.recursion;

/**
 * Created by demi
 * on 18.06.15.
 */
public class Basic3 {
	public static void main(String[] args) {
		f(1);
	}

	public static void f(int arg) {
		System.out.print(" " + arg);
		if (arg < 7) {
			f(arg * 2);
		}
		System.out.print(" " + arg);
	}
}