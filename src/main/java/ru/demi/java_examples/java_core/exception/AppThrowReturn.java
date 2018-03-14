package ru.demi.java_examples.java_core.exception;

/**
 * Created by demi
 * on 01.07.15.
 * <p>
 * return in finally kills exception from try!!!
 */
public class AppThrowReturn {
	public static void main(String[] args) {
		System.err.println(0);
		try {
			if (true) throw new Error();
		} finally {
			System.err.println(1);
			if (true) return;
		}
		System.err.println(2);
	}
}
