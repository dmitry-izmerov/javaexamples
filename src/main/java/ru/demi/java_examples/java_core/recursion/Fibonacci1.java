package ru.demi.java_examples.java_core.recursion;

/**
 * Created by demi
 * on 20.06.15.
 */
public class Fibonacci1 {
	public static void main(String[] args) {
		fib(5);
	}

	public static int fib(int arg) {
		int res = (arg < 2) ? 1 : fib(arg - 2) + fib(arg - 1);
		System.out.print(" " + arg);
		return res;
	}
}
