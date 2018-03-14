package ru.demi.java_examples.java_core.exception;

/**
 * Created by demi
 * on 04.07.15.
 */
public class AddSuppressed {
	public static void main(String[] args) {
		Error ex = new Error("A");
		ex.addSuppressed(new Error("B"));
		ex.addSuppressed(new Error("C"));
		throw ex;
	}
}
