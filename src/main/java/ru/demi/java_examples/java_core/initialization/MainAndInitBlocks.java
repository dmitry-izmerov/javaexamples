package ru.demi.java_examples.java_core.initialization;

/**
 * @author demi
 * @date 14.01.17
 */
public class MainAndInitBlocks {
	{
		System.out.println("non-static init");
	}

	public static void main(String a[]) {
		System.out.println("main");
		MainAndInitBlocks ob1 = new MainAndInitBlocks();
	}

	static {
		System.out.println("static init");
	}
}
