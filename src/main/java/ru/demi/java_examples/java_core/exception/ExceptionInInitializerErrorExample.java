package ru.demi.java_examples.java_core.exception;

/**
 * @author demi
 * @date 08.01.17
 * <p>
 * public class ExceptionInInitializerError extends LinkageError
 * Signals that an unexpected exception has occurred in a static initializer.
 * An ExceptionInInitializerError is thrown to indicate that an exception occurred
 * during evaluation of a static initializer or the initializer for a static variable.
 */
public class ExceptionInInitializerErrorExample {

	static final boolean fromStatic = false;

	static int x;

	static {
		if (fromStatic) {
			x = 1 / 0;
		}
	}

	{
		if (!fromStatic) {
			int x = 1 / 0;
		}
	}

	public static void main(String[] args) {
		if (fromStatic) {
			System.out.println(ExceptionInInitializerErrorExample.x);
		} else {
			new ExceptionInInitializerErrorExample();
		}
	}
}
