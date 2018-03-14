package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App01 {
	public static void main(String[] args) throws InterruptedException {
		// !!! java.lang.IllegalMonitorStateException
		new Object().wait();
//        new Object().notify();
	}
}
