package ru.demi.java_examples.java_core.oop.nested;

/**
 * Created by demi
 * on 13.07.15.
 */
public class App01 {
	static int k;

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println(k);
			}
		};
		r.run();
	}
}
