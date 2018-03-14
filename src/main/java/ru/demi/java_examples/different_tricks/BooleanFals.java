package ru.demi.java_examples.different_tricks;

/**
 * @author demi
 * @date 21.12.16
 */
public class BooleanFals {
	public static void main(String[] args) {
		Boolean a1 = new Boolean("fals"); // return false
		Boolean a2 = new Boolean("true");
		Integer v1 = 1237; // hashcode for false
		Integer v2 = 1231; // hashcode for true
		System.out.println(a1.hashCode() == v1.hashCode()
			&& a2.hashCode() == v2.hashCode());
	}
}
