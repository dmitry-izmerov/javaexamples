package ru.demi.java_examples.java_core.oop.polymorphism;

/**
 * @author demi
 * @date 14.01.17
 */
public class PolymorphismAndPrivateMethod {
	private String runNow() {
		return "High";
	}

	static class B extends PolymorphismAndPrivateMethod {
		public String runNow() {
			return "Low";
		}
	}

	public static void main(String args[]) {
		PolymorphismAndPrivateMethod[] a = new B[]{new B(), new C()};
		for (PolymorphismAndPrivateMethod aa : a)
			System.out.print(aa.runNow() + " ");
	}
}

class C extends PolymorphismAndPrivateMethod.B {
	public String runNow() {
		return "Out";
	}
}