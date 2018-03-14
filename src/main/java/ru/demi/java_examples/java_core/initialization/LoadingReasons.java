package ru.demi.java_examples.java_core.initialization;

/**
 * @author demi
 * @date 08.01.17
 */
public class LoadingReasons {
	static class A {
		private static int v = func();

		private static int func() {
			System.out.print("A");
			return 0;
		}
	}

	static class B {
		private static int v = func();

		public static int func() {
			System.out.print("B");
			return 0;
		}
	}

	static class C {
		private static int v = func();

		public static int func() {
			System.out.print("C");
			return 0;
		}
	}

	public static void main(String[] args) {
		B b;
		C.func();
		b = new B();
		System.out.println();
	}

	/**
	 * Пояснение: Краткий перевод спеки (пункт 2.4.1):
	 * Класс Т инициализируется в одном из следующий 5 случаев:
	 * 1. Создается объект класса Т.
	 * 2. Вызывется статичный метод класса Т.
	 * 3. Статичной переменной класса Т присваивается значение (вне класса).
	 * 4. Статичная (не константная) переменная класса Т используется.
	 * 5. Т - внешний класс и внутри него выполняется конструкция assert.
	 *
	 * Таким образом первое упоминание класса В не запускает инициализацию класса.
	 */
}
