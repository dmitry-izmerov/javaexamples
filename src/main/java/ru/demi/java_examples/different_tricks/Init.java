package ru.demi.java_examples.different_tricks;

/**
 * @author demi
 * @date 21.12.16
 * <p>
 * Пояснение: Порядок инициализации:
 * 1) Загрузка класса в память
 * 2) Инициализация static переменных и выполнение static блоков
 * 3) Инициализация атрибутов объекта
 * 4) Выполнение конструктора Важно знать, что между первым и вторым шагами
 * все статик переменные принимают значение по умолчанию и в этом месте уже можно создавать объект данного типа.
 */
public class Init {
	static class Class1 {

		public static final Class2 CLASS_2 = new Class2("from static");

		public Class1(String arg) {
			System.out.println(getClass().getSimpleName() + " " + arg);
			System.out.println(Class2.CLASS_1);
			System.out.println(Class1.CLASS_2);
		}

		@Override
		public String toString() {
			return "Class1 to string";
		}
	}

	static class Class2 {
		public static final Class1 CLASS_1 = new Class1("from static");

		public Class2(String arg) {
			System.out.println(getClass().getSimpleName() + " " + arg);
			System.out.println(Class2.CLASS_1);
			System.out.println(Class1.CLASS_2);
		}

		@Override
		public String toString() {
			return "Class2 to string";
		}
	}

	public static void main(String[] args) {
		new Class1("from main");
	}
}
