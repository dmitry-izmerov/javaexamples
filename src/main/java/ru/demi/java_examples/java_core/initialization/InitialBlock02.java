package ru.demi.java_examples.java_core.initialization;

class One {
	public static int j = 90;

	// this is constructor!!!
	One() {
		j = 12;
	}
}

public class InitialBlock02 extends One {
	public static void main(String args[]) {
		new InitialBlock02();
		System.out.println(One.j);
	}
}