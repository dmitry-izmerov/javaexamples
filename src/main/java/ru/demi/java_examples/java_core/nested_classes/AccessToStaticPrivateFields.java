package ru.demi.java_examples.java_core.nested_classes;

/**
 * @author demi
 * @date 11.12.16
 */
public class AccessToStaticPrivateFields {
	private static String field = "private field";

	static class NestedClass {
		public NestedClass() {
			System.out.println(field);
		}
	}

	public static void main(String[] args) {
		new AccessToStaticPrivateFields.NestedClass();
	}
}
