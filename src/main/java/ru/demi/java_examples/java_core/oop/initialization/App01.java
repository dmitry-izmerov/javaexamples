package ru.demi.java_examples.java_core.oop.initialization;

/**
 * Created by demi
 * on 11.07.15.
 */
public class App01 {
	static class A {
		A() {
			System.out.println("A");
		}
	}

	static class B extends A {
		B() {
			System.out.println("B");
		}
	}

	static class C extends B {
		C() {
			System.out.println("C");
		}
	}

	public static void main(String[] args) {
		B ref = new C();
	}
}
