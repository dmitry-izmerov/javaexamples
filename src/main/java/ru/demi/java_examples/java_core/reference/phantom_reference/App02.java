package ru.demi.java_examples.java_core.reference.phantom_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 30.06.15.
 */
public class App02 {
	public static void main(String[] args) throws InterruptedException {
		ReferenceQueue<Integer> referenceQueue = new ReferenceQueue<>();
		List<PhantomReference<Integer>> list = new ArrayList<>();

		for (int i = 0; i < 500_000; i++) {
			list.add(new PhantomReference<>(i, referenceQueue));
		}

		System.gc();
		Thread.sleep(500);

		Reference<? extends Integer> ref;
		while ((ref = referenceQueue.poll()) != null) {
			System.out.println(ref.get());
			ref.clear();
		}
	}
}
