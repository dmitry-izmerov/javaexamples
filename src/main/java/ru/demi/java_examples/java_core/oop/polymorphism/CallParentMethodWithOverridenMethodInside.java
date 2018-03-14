package ru.demi.java_examples.java_core.oop.polymorphism;

/**
 * @author demi
 * @date 21.05.16
 */
public class CallParentMethodWithOverridenMethodInside {
	static class Parent {

		public int getValue() {
			return 0;
		}

		public void print() {
			System.out.println(getValue());
		}

	}

	static class Child extends Parent {
		public int getValue() {
			return 1;
		}
	}

	public static void main(String[] args) {
		Parent p = new Child();
		p.print(); // 1
	}
}
