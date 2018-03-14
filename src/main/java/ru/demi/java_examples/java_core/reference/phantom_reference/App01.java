package ru.demi.java_examples.java_core.reference.phantom_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 30.06.15.
 * <p>
 * PhantomReference используется для сложной процедуры удаления объекта.
 * Это может быть необходимо, когда объект что-то делает за границами JVM, например,
 * вызывает низкоуровневые функции ОС или пишет свое состояние в файл или еще что-нибудь очень важное.
 */
public class App01 {
	public static void main(String[] args) throws InterruptedException {
		List<PhantomReference<byte[]>> list = new ArrayList<>();
		ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
		while (true) {
			System.out.println();
			for (PhantomReference<byte[]> ref : list) {
				System.out.print(ref.get() == null ? "*" : "E");
			}
			list.add(new PhantomReference<>(new byte[10_000_000], referenceQueue));
			Thread.sleep(100);

			System.out.println();
			Reference<? extends byte[]> ref = referenceQueue.poll();
			System.out.println("Does have Phantom ref object? -  " + (ref != null));
			if (ref != null) {
				ref.clear();
			}
		}
	}
}
