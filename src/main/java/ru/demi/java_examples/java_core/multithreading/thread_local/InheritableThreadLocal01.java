package ru.demi.java_examples.java_core.multithreading.thread_local;

/**
 * Created by demi
 * on 23.07.15.
 */
public class InheritableThreadLocal01 {
	public static void main(String[] args) throws InterruptedException {
		final InheritableThreadLocal<String> str = new InheritableThreadLocal<>();
		System.out.println(str.get());
		str.set("Hello");
		System.out.println(Thread.currentThread().getName() + " - " + str.get());

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " - " + str.get());
				str.set("Changed value");
				System.out.println(Thread.currentThread().getName() + " - " + str.get());
			}
		});
		t.start();
		t.join();
		System.out.println(Thread.currentThread().getName() + " - " + str.get());

	}
}
