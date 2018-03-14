package ru.demi.java_examples.java_core.oop.overriding;

/**
 * Created by demi
 * on 28.11.15.
 */
public class Parent {
	protected void print() {
		System.out.println("Parent.print()");
	}

	public void print(String... args) {
		for (String arg : args) {
			System.out.print(arg + " ");
		}
		System.out.println("Parent.print(String[])");
	}
}
