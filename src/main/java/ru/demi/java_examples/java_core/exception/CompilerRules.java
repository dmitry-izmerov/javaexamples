package ru.demi.java_examples.java_core.exception;

/**
 * Created by demi
 * on 04.07.15.
 */
public class CompilerRules {
	public static void main(String[] args) throws Throwable {
		try {
			Throwable t = new RuntimeException();
			throw t;
		} catch (Exception e) {
			System.out.println("Catched!");
		}
	}
}
