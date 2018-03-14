package ru.demi.java_examples.java_core.reference.phantom_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 30.06.15.
 */
public class App03 {
	static class PhantomCallOuterResources extends PhantomReference<String> {

		/**
		 * Creates a new phantom reference that refers to the given object and
		 * is registered with the given queue.
		 * <p>
		 * <p> It is possible to create a phantom reference with a <tt>null</tt>
		 * queue, but such a reference is completely useless: Its <tt>get</tt>
		 * method will always return null and, since it does not have a queue, it
		 * will never be enqueued.
		 *
		 * @param referent the object the new phantom reference will refer to
		 * @param q        the queue with which the reference is to be registered,
		 */
		public PhantomCallOuterResources(String referent, ReferenceQueue<? super String> q) {
			super(referent, q);
		}

		/**
		 * Close outer resource!!!
		 */
		private void close() {
			System.out.println("Resource was closed!");
		}
	}

	public static void main(String[] args) {
		ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();

		List<PhantomCallOuterResources> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String s = "Resource #" + i;
			list.add(new PhantomCallOuterResources(s, referenceQueue));
		}

		// thread for references
		Thread referenceThread = new Thread() {
			public void run() {
				while (true) {
					try {
						PhantomCallOuterResources ref = (PhantomCallOuterResources) referenceQueue.remove();
						// !!! close outer resource
						System.out.println("Close resource " + ref.get());
						ref.close();
						ref.clear();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		referenceThread.setDaemon(true);
		referenceThread.start();
	}
}
