package ru.demi.java_examples.java_core.initialization;

/**
 * Created by demi
 * on 18.06.15.
 * <p>
 * The Java compiler copies initializer blocks into every constructor.
 * Therefore, this approach can be used to share a block of code between multiple constructors.
 */
public class InitialBlock01 {
	{
		// error here !!!
		// System.out.println(i);
		System.out.println("in first initial block");
	}

	public int i;

	{
		System.out.println(i);
		System.out.println("in second initial block");
		i = 1;
		System.out.println(i);
	}

	public InitialBlock01() {
		System.out.println("in constructor");
		i = 2;
		System.out.println(i);
	}

	public static void main(String[] args) {
		new InitialBlock01();
	}
}
