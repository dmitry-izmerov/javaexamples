package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App04 {
	public static void main(String[] args) throws InterruptedException {
		Object ref = new Object();
		synchronized (ref) {
			synchronized (ref) {
				synchronized (ref) {
					synchronized (ref) {
						// reentrant lock
						ref.notify();
					}
				}
			}
		}
	}
}
