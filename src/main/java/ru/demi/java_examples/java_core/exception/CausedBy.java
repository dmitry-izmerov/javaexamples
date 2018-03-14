package ru.demi.java_examples.java_core.exception;

/**
 * Created by demi
 * on 02.07.15.
 */
public class CausedBy {
	public static void main(String[] args) throws Exception {
		try {
			try {
				throw new Error();
			} catch (Error e) {
				throw new RuntimeException(e);
			}
		} catch (RuntimeException e) {
			throw new Exception(e);
		}
	}
}
