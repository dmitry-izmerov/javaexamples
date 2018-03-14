package ru.demi.java_examples.java_core.format;

import java.util.Formatter;
import java.util.Locale;

/**
 * @author demi
 * @date 05.01.17
 */
public class FormatterExample {
	public static void main(String[] args) {
		Formatter formatter = new Formatter(Locale.ROOT);
		formatter.format("%.2E\n", 100.0 / 3.0);      //1
		formatter.format("%.2f", 100.0 / 3.0);        //2
		System.out.println(formatter);
	}
}
