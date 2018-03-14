package ru.demi.java_examples.java_8.lambda;

/**
 * Created by demi
 * on 19.06.15.
 */
public class Calculator {
	public static void main(String... args) {
		Calculator calculator = new Calculator();
		MathInteger add = (a, b) -> a + b;
		MathInteger subtract = (a, b) -> {
			return a - b;
		};
		System.out.println("a + b = " + calculator.operate(1, 2, add));
		System.out.println("a - b = " + calculator.operate(1, 2, subtract));
	}

	interface MathInteger {
		int operate(int a, int b);
	}

	public int operate(int a, int b, MathInteger op) {
		return op.operate(a, b);
	}
}
