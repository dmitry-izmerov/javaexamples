package ru.demi.java_examples.java_core.reference.weak_reference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 29.06.15.
 */
public class App01 {
	public static void main(String[] args) throws InterruptedException {
		List<WeakReference<byte[]>> list = new ArrayList<>();
		while (true) {
			System.out.println();
			for (WeakReference<byte[]> weakReference : list) {
				System.out.print(weakReference.get() == null ? "*" : "E");
			}
			list.add(new WeakReference<>(new byte[10_000_000]));
			Thread.sleep(100);
		}
	}
}
