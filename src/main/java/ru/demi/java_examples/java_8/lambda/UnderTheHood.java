package ru.demi.java_examples.java_8.lambda;

/**
 * @author demi
 * @date 12.02.17
 */
public class UnderTheHood {
	public static void main(String[] args) {
		Thread th;
		// from Java 8 its used inokedynamic instruction in bytecode for lambda
		// and you wont see any created inner classes in folder with .class files
		// for code below!!!
		th = new Thread(() -> System.out.println("Is this inner class?"));
		th = new Thread(() -> System.out.println("Is this inner class?"));
		th = new Thread(() -> System.out.println("Is this inner class?"));
		th = new Thread(() -> System.out.println("Is this inner class?"));
		th = new Thread(() -> System.out.println("Is this inner class?"));
		th.start();
	}
}
