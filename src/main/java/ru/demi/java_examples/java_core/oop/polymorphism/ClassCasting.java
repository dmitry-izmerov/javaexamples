package ru.demi.java_examples.java_core.oop.polymorphism;

/**
 * @author demi
 * @date 05.01.17
 */
public class ClassCasting {
	static class Parent {
	}

	static class DerivedOne extends Parent {
	}

	static class DerivedTwo extends Parent {
	}

	public static void main(String[] args) {
		Parent p = new Parent();
		DerivedOne d1 = new DerivedOne();
		DerivedTwo d2 = new DerivedTwo();
		// compile error here!!!
		// d1 = (DerivedOne) d2;
	}
}
