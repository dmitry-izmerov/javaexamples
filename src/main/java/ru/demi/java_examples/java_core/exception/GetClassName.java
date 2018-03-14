package ru.demi.java_examples.java_core.exception;

/**
 * Created by demi
 * on 26.07.15.
 */
public class GetClassName {
	public static void main(String[] args) {
		System.out.println(getClassName());
	}

	public static String getClassName() {
		try {
			throw new Exception();
		} catch (Exception e) {
			return e.getStackTrace()[1].getClassName();
		}
	}
}
