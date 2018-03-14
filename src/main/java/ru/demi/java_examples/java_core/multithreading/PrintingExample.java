package ru.demi.java_examples.java_core.multithreading;

/**
 * @author demi
 * @date 14.01.17
 */
public class PrintingExample {
	private static Thread threadA, threadB;

	public static void main(String[] args) {
		threadA = new Thread() {
			public void run() {
				System.out.println("A");
				try {
					threadB.sleep(1000); // sleep for threadA!!!
				} catch (Exception e) {
					System.out.println("B");
				}
				System.out.println("C");
			}
		};

		threadB = new Thread() {
			public void run() {
				System.out.println("D");
				try {
					threadA.wait();
				} catch (Exception e) {
					System.out.println("E");
				}
				System.out.println("F");

			}
		};

		threadA.start();
		threadB.start();
	}
}
