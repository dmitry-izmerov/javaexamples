package ru.demi.java_examples.different_tricks;

/**
 * @author demi
 * @date 21.12.16
 */
public class FloatDoublePrecision {
	public static void main(String[] args) {
		System.out.println(0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f);
		System.out.println(0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d);

		// comment from test site http://www.quizful.net/testRun/Z4yGSuxPpJqv
		/**
		 * Да, извиняюсь, погорячился :). Здесь весь секрет в том как представляется число 0.1 в двоичной системе.
		 * После преобразования оно выглядит как 0,000110011(0011) (0011 в периоде) и поскольку типы float и double
		 * имеют определенный размер, появляется неточность, а разные значения получаются от того что эти типы имеют разный размер.
		 */
	}
}
