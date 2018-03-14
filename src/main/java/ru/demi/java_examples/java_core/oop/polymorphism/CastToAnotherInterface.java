package ru.demi.java_examples.java_core.oop.polymorphism;

/**
 * @author demi
 * @date 05.01.17
 */
public class CastToAnotherInterface {

	public static void main(String[] args) {
		Impl impl = new Impl();
		I_A a;
		a = impl;
		a.out1();
		((I_B) a).out2();
	}

	interface I_A {
		public void out1();
	}

	interface I_B {
		public void out2();
	}

	static class Impl implements I_A, I_B {
		public void out2() {
			System.out.print("2");
		}

		public void out1() {
			System.out.print("1");
		}
	}
}

