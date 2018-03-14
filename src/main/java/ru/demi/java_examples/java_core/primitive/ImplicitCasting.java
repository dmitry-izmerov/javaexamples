package ru.demi.java_examples.java_core.primitive;

/**
 * @author demi
 * @date 03.01.17
 */
public class ImplicitCasting {
	public static void main(String[] args) {
		// result of arithmetic operation is integer type
		byte a = 1;
		byte b = (byte) -a;
		System.out.println(b);
		short c = 2;
		short d = 1;
		short e = (short) (c + d);
		short f = (short) (c - d);
		short g = (short) (c * d);
		short h = (short) (c / d);

		// there is exception if one of operands has long type
		// then result will be also long
		// also this is same for float and double types
		byte i = 1;
		long j = 2;
		System.out.println(((Object) (i + j)).getClass().getName());

		// increment/decrement does not cast return value to integer
		short k = c++;
		short l = --c;

		// auto casting
		byte m = 2;
		double n = m + 1;
	}
}
