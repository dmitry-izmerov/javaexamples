package ru.demi.java_examples.java_core.annotation;

/**
 * @author demi
 * @date 03.01.17
 */
public class SuppressWarningDeprecation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		new A().test();
		new B().test();
	}

	private static class A {
		@Deprecated
		public void test() {
			System.out.println("test");
		}
	}

	private static class B extends A {
		@Override
		public void test() {
			System.out.println("child.test");
		}
	}
}
