package ru.demi.java_examples.java_core.operators;

import java.util.Arrays;
import java.util.List;

/**
 * @author demi
 * @date 08.01.17
 * <p>
 * https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.25
 */
public class TernaryOperator {

	public static void main(String[] args) {
		// If one of the operands is of type byte or Byte and the other is of type short or Short,
		// then the type of the conditional expression is short.
		Object result = true ? (byte) 1 : (short) 2;
		System.out.println(result.getClass() + " " + result);

		// If one of the operands is of type T where T is byte, short, or char,
		// and the other operand is a constant expression (§15.28) of type int
		// whose value is representable in type T, then the type of the conditional expression is T.
		result = true ? 1 : (byte) 2;
		System.out.println(result.getClass() + " " + result);

		System.out.println(true ? 1 : new Short((short) 2));
		System.out.println(result.getClass() + " " + result);

		// @see https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.6.2
		result = true ? new Integer("1") : new Float("5");
		System.out.println(result.getClass() + " " + result);

		List<String> ls = true ? Arrays.asList() : Arrays.asList("a", "b");
		System.out.println(ls.getClass());
	}
}
