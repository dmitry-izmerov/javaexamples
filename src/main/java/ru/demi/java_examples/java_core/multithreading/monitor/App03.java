package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App03 {
	public static void main(String[] args) throws InterruptedException {
		// !!! java.lang.IllegalMonitorStateException
		synchronized (new Object()) {
			new Object().wait();
		}
	}
}
