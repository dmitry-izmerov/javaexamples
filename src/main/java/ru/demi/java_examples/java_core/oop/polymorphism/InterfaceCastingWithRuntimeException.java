package ru.demi.java_examples.java_core.oop.polymorphism;

/**
 * @author demi
 * @date 05.01.17
 */
public class InterfaceCastingWithRuntimeException {
	static class Parent implements DerivedOne, DerivedTwo {
	}

	static class Parent1 implements DerivedOne {
	}

	static class Parent2 implements DerivedTwo {
	}

	static interface DerivedOne {
	}

	static interface DerivedTwo {
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Parent p = new Parent();
		DerivedOne d1 = new Parent1();
		DerivedTwo d2 = new Parent2();
		//d1 = (DerivedOne) d2;

		System.out.println("Before class loading");
		System.out.println(C.i);
		System.out.println("After class loading");
	}

	static class C {
		static int i = value();

		static int value() {
			System.out.println("C.i initialized");
			return 1;
		}
	}
}
