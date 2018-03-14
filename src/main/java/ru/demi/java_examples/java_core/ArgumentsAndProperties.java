package ru.demi.java_examples.java_core;

import java.util.Properties;

/**
 * @author demi
 * @date 08.01.17
 */
public class ArgumentsAndProperties {
	public static void main(String[] args) {
		Properties props = System.getProperties();
		props.put(args[0], args[1]);
		System.out.print(props.get("1"));
		System.out.print(props.get("2"));
		System.out.print(props.get("3"));
	}
}
