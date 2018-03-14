package ru.demi.java_examples.different_tricks;

/**
 * @author demi
 * @date 21.12.16
 */
public class ExampleIllegalMonitorStateException {

	static class Walker extends Thread {

		private static volatile String previousWalkerName;

		private final String walkerName;

		private Walker(String walkerName) {
			this.walkerName = walkerName;
		}

		@Override
		public void run() {
			synchronized (previousWalkerName) {
				for (; ; ) {
					while (previousWalkerName == walkerName) {
						try {
							previousWalkerName.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					previousWalkerName = walkerName; // illegal change of sync object

					previousWalkerName.notifyAll();

					System.out.println("I am " + previousWalkerName + ", and it is my turn to walk!");
				}
			}
		}
	}

	public static void main(String... args) {
		String firstWalker = "first walker";
		String secondWalker = "second walker";

		Walker.previousWalkerName = secondWalker;

		new Thread(new Walker(secondWalker)).start();
		new Thread(new Walker(firstWalker)).start();
	}
}
