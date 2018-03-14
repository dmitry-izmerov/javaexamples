package ru.demi.java_examples.java_core.initialization;

/**
 * Created by demi
 * on 30.11.15.
 * <p>
 * Look at Javarush level15 lesson 8
 */
public class VariablesInitOrder {
	/**
	 * What's really going on
	 * private int a = 0;
	 * private int b = 0;
	 * private int c = 0;
	 * <p>
	 * public VariablesInitOrder()
	 * {
	 * super();
	 * a = getSum();
	 * b = getSum() - a;
	 * c = getSum() - a - b;
	 * <p>
	 * // constructor actions
	 * }
	 */
	private int a = getSum();
	private int b = getSum() - a;
	private int c = getSum() - a - b;

	volatile static long aa = 0;

	public int getSum() {
		return a + b + c;
	}

	public static void main(String[] args) {
		System.out.println(new VariablesInitOrder().a);
		System.out.println(new VariablesInitOrder().b);
		System.out.println(new VariablesInitOrder().c);
	}
}
