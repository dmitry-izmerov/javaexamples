package ru.demi.java_examples.java_core.oop.initialization;

/**
 * Created by demi
 * on 11.07.15.
 * В конструкторе первой строкой должен быть вызов super или this !!!
 */
public class App02 {

	static class X {
		public X(int x) {
			// super();
			System.out.println("X(int)");
		}

		public X(String s) {
			this(0);
			System.out.println("X(String)");
		}
	}

	static class Y extends X {
		public Y() {
			super("");
			System.out.println("Y()");
		}

		public Y(int x, int y) {
			this();
			System.out.println("Y(int, int)");
		}
	}

	public static void main(String[] args) {
		new Y(0, 0);
	}
}
