package ru.demi.java_examples.java_core.exception;

/**
 * Created by demi
 * on 15.07.15.
 */
public class Finally01 {
	public static void main(String[] args) {
		System.out.println(f());
	}

	public static int f() {
		try {
			return 1;
		} finally {
			return 0;
		}
	}
}
