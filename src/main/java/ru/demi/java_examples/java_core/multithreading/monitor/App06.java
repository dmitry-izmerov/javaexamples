package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App06 {
	public static void main(String[] args) throws InterruptedException {
		Object ref1 = new Object();
		Object ref2 = new Object();
		synchronized (ref1) {
			synchronized (ref2) {
				ref1.notify();
				ref1.notify();
				ref2.notify();
				ref2.notify();
			}
		}
	}
}
