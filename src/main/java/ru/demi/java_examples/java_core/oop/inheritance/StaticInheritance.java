package ru.demi.java_examples.java_core.oop.inheritance;

/**
 * @author demi
 * @date 28.05.16
 * <p>
 * Пояснение: Класс С не будет загружаться, то есть статический блок в классе С не будет выполняться! Почему?
 * Загрузка класса выполнятся в таких условиях:
 * Обращение к СТАТИЧЕСКИМ ПЕРЕМЕННЫМ КЛАССА, статическому методу, создание объекта данного класса и тд..
 * В данном случае мы обращаемся ИМЕННО К СТАТИЧЕСКОЙ ПЕРЕМЕННОЙ КЛАССА B но не к статической переменной
 * класса С - C.x - данная запись конечно критична, но жизнеспособна.
 * Исходя от этого мы делаем вывод:
 * 1) Статическая переменная x принадлежит классу B, но так как B extends A - то самым первым выполнится
 * статический блок в классе A
 * 2) Выполнение статического блока в классе B
 * 3) Ну и вывод - AB5
 */
public class StaticInheritance {
	public static void main(String[] args) {
		System.out.print(C.x);
	}

	static class A {
		static {
			System.out.print("A");
		}
	}

	static class B extends A {
		public static int x = 5;

		static {
			System.out.print("B");
		}
	}

	static class C extends B {
		static {
			System.out.print("C");
			System.exit(0);
		}
	}
}
