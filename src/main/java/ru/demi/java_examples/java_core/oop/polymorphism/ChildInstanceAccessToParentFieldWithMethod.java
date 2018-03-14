package ru.demi.java_examples.java_core.oop.polymorphism;


public class ChildInstanceAccessToParentFieldWithMethod {

	public static void main(String[] args) {
		// call parent method
		new Child().printXQ(); // 0
	}

	static class Parent {

		private int x = 0;

		public void printXQ() {
			System.out.println(x);
		}
	}

	static class Child extends Parent {
		int x = -1;
	}
}

