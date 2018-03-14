package ru.demi.java_examples.java_core.format;

/**
 * @author demi
 * @date 14.01.17
 */
public class HbFormat {
	int i = 10;
	byte b = 5;

	public int hashCode() {
		return i;
	}

	public static void main(String... a) {
		System.out.println(String.format(" %1$b  ", new Boolean("fAlSe")));
		System.out.println(String.format(" %1$H %2$s", new HbFormat(), null));
	}
}
