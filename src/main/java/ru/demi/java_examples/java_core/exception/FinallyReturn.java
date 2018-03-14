package ru.demi.java_examples.java_core.exception;

/**
 * Created by demi
 * on 01.07.15.
 */
public class FinallyReturn {
	public static void main(String[] args) {
		System.out.println(f());
	}

	public static int f() {
		try {
			return 0;
		} finally {
			return 1;
		}
	}
}
