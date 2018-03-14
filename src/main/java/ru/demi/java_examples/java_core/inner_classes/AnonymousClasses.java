package ru.demi.java_examples.java_core.inner_classes;

/**
 * @author demi
 * @date 11.12.16
 */
public class AnonymousClasses {

	public static void main(String[] args) {
		new Thread(new Runnable() {

			// instead of constructor
			{
				System.out.println("In init block");
			}

			@Override
			public void run() {
				System.out.println("the thread is running.");
			}
		}).start();
	}
}
