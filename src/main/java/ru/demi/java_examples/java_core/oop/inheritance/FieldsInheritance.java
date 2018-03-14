package ru.demi.java_examples.java_core.oop.inheritance;

/**
 * @author demi
 * @date 28.05.16
 * <p>
 * Что будет выведено на экран в результате компиляции и выполнения следующего кода?
 * <p>
 * Пояснение: Классы B1 и B2 расширяют класс A и перекрывают его публичную переменную 'str' своими переменными,
 * но оригинальное поле продолжает существовать. При обращении к объекту любого из этих классов по ссылке типа A,
 * обращение происходит к полю 'str' класса A. А при обращении по ссылке B1 или B2 - к перекрывающему полю.
 */
public class FieldsInheritance {

	static class A {
		public String str;
	}

	static class B1 extends A {
		public String str;
	}

	static class B2 extends A {
		public int str;                    // 1
	}

	static void m(A a) {
		a.str = "string";
	}

	public static void main(String[] args) throws Exception {
		A a = new A();
		B1 b1 = new B1();
		B2 b2 = new B2();

		m(a);
		m(b1);
		m(b2);                            // 2

		System.out.println(a.str);
		System.out.println(b1.str);
		System.out.println(b2.str);        // 3
	}
}
