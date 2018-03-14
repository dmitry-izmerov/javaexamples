package ru.demi.java_examples.java_core.reference.soft_reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 29.06.15.
 */
public class App01 {
	public static void main(String[] args) throws InterruptedException {
		List<SoftReference<byte[]>> list = new ArrayList<>();
		while (true) {
			System.out.println();
			for (SoftReference<byte[]> ref : list) {
				System.out.print(ref.get() == null ? "*" : "E");
			}
			list.add(new SoftReference<>(new byte[10_000_000]));
			Thread.sleep(100);
		}
	}
}
