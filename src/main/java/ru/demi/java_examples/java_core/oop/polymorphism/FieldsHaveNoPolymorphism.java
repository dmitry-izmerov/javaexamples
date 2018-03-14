package ru.demi.java_examples.java_core.oop.polymorphism;

/**
 * @author demi
 * @date 12.01.17
 */
public class FieldsHaveNoPolymorphism {
	static class Greek {

		int i = 1;

		public int getI() {
			System.out.print("Super");
			return i;
		}
	}

	static class Arabik extends Greek {

		int i = 2;

		public int getI() {
			System.out.print("Sub");
			return i;
		}
	}

	public static void main(String arhs[]) {
		Greek ga = new Arabik();
		System.out.print(ga.i + " " + ga.getI());
	}
}
