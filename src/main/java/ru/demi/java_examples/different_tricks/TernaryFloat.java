package ru.demi.java_examples.different_tricks;

/**
 * @author demi
 * @date 21.12.16
 */
public class TernaryFloat {
	public static void main(String[] args) {
		java.util.Random r = new java.util.Random();
		boolean bool = r.nextBoolean();
		Object result = (bool || !bool) ? new Integer("1") : new Float("5");
		System.out.println(result.getClass() + " " + result);
	}
}
