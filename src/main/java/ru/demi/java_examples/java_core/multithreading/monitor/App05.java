package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App05 {
	public static void main(String[] args) throws InterruptedException {
		Object ref1 = new Object();
		Object ref2 = ref1;
		synchronized (ref1) {
			ref2.notify();
		}
	}
}
