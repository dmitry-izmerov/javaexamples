package ru.demi.java_examples.java_core.multithreading.daemon;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App02 {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			while (true) ;
		});
		t.setDaemon(true);
		t.start();

		System.out.println("End Main Thread");
	}
}
