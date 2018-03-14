package ru.demi.java_examples.java_core.oop;

/**
 * @author demi
 * @date 07.01.17
 */
public class LifeIsPain {
	public static class X {
		public static class Y {
			public static String Z = "life is good";
		}

		public static C Y;
	}

	public static class C {
		public static String Z = "life is pain";
	}

	public static void main(String[] args) {
		System.out.println(X.Y.Z);
	}
}
