package ru.demi.java_examples.java_core.initialization;

/**
 * @author demi
 * @date 05.01.17
 */
public class StaticFieldsInitOrder {
	static int i1 = initialize("i1");

	static int i2;

	static {
		i2 = initialize("i2");
	}

	static int i3 = initialize("i3");

	static int i4;

	static {
		i4 = initialize("i4");
	}

	static int initialize(String name) {
		System.out.println(name);
		return 0;
	}

	public static void main(String[] args) {
	}
}
