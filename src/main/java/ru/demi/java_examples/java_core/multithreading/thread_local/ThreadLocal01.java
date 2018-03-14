package ru.demi.java_examples.java_core.multithreading.thread_local;

/**
 * Created by demi
 * on 23.07.15.
 */
public class ThreadLocal01 {
	public static void main(String[] args) throws InterruptedException {
		final ThreadLocal<String> str = new ThreadLocal<>();
		System.out.println(str.get());
		str.set("Hello");
		System.out.println(Thread.currentThread().getName() + " - " + str.get());

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " - " + str.get());
			}
		});
		t.start();
		t.join();
	}
}
