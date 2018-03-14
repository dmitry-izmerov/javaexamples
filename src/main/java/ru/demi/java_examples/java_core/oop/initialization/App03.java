package ru.demi.java_examples.java_core.oop.initialization;

/**
 * @author demi
 * @date 28.05.16
 * <p>
 * Каким будет результат компиляции и выполнения следующего кода?
 */
public class App03 {

	public static void main(String... args) {
		C c = new C();
	}

	static class A {
		static {
			System.out.println("static A1");
		}

		A() {
			System.out.println("A");
		}
	}

	static class B extends A {
		static {
			System.out.println("static B1");
		}

		B() {
			System.out.println("B");
		}
	}

	static class C extends B {
		static {
			System.out.println("static C1");
		}

		{
			System.out.println("non static C1");
		}

		C() {
			this("Hello");
			System.out.println("C1");
		}

		C(String str) {
			System.out.println("C2");
		}

		{
			System.out.println("non static C2");
		}
	}
}
