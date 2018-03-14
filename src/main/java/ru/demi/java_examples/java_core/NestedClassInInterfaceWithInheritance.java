package ru.demi.java_examples.java_core;

/**
 * @author demi
 * @date 15.01.17
 */
public class NestedClassInInterfaceWithInheritance {
	static interface I {
		class Inner {
			Inner() {
				System.out.print(j++);
			}

			static int j;
		}
	}

	Float f = (float) 9.81;

	static class B implements I {
	}

	static class C extends B implements I {
		public class Inner2 extends Inner {
		}
	}

	public static void main(String[] args) {
		I.Inner ii = new I.Inner();
		I.Inner ib = new B.Inner();
		B.Inner bb = new B.Inner();
		B.Inner bi = new I.Inner();
		C.Inner ci = new C.Inner();
		C.Inner ci2 = new C().new Inner2();
	}
}

class Count$1 {
}
