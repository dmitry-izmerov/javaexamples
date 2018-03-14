package ru.demi.java_examples.java_core.oop.inheritance;

/**
 * Created by demi
 * on 12.07.15.
 * Виртуальными являются только методы !!!
 * Поля, статические поля, стат методы не являются виртуальными !!!
 */
public class App {

	static class Parent {
		int field;
	}

	static class Child extends Parent {
		int field;
	}

	public static void main(String[] args) {
		Child refChild = new Child();
		Parent refParent = refChild;
		refChild.field = 1;
		refParent.field = 2;
		System.out.println(refChild.field);
		System.out.println(refParent.field);
	}
}
