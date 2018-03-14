package ru.demi.java_examples.java_core.enumeration;

import java.util.Arrays;

/**
 * @author demi
 * @date 11.12.16
 */
public class EnumSimple {

	enum Season { // == class Season extends java.lang.Enum
		WINTER,
		SPRING,
		SUMMER,
		AUTUMN
	}

	public static void main(String[] args) {
		Season season = Season.WINTER;
		System.out.println(Season.class.getSuperclass()); // class java.lang.Enum
		System.out.println("season.name()=" + season.name() + ", season.ordinal()=" + season.ordinal() + ", season.toString()=" + season.toString());

		// Довольно часто возникает задача получить элемент enum по его строковому представлению.
		// Для этих целей в каждом enum-классе компилятор автоматически создает
		// специальный статический метод: public static EnumClass valueOf(String name),
		// который возвращает элемент перечисления EnumClass с названием, равным name.
		String seasonName = "SPRING";
		System.out.println(Season.valueOf(seasonName));

		try {
			System.out.println(Season.valueOf("SOME SEASON"));
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(Season.valueOf(null));
		} catch (Exception e) {
			System.out.println(e);
		}

		// Иногда необходимо получить список всех элементов enum-класса во время выполнения.
		// Для этих целей в каждом enum-классе компилятор создает метод:
		// public static EnumClass[] values()
		System.out.println(Arrays.toString(Season.values()));
	}
}
