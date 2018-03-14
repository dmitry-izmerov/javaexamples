package ru.demi.java_examples.java_core.oop;

/**
 * @author demi
 * @date 10.01.17
 */
public class DifferentCastings {
	interface Min {
	}

	static class A {
	}

	static class B extends A implements Min {
	}

	static class C extends B {
	}

	public static void main(String args[]) {
		A a = new A();
		B b = new B();
		C c = new C();
		Min m = null;
		b = (C) m; // ??
		m = (Min) b;
		A a2 = (A) m;
		B b2 = (B) a2;
		Min m2 = (C) b2; // ??
		C c2 = (C) m2;
	}
}
