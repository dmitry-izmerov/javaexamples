package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 11.07.15.
 */
public class SingleElementBuffer {
	private Integer elem = null;

	public synchronized void put(int newElem) throws InterruptedException {
		while (this.elem != null) {
			this.wait();
		}
		this.elem = newElem;
		this.notifyAll();
	}

	public synchronized int get() throws InterruptedException {
		while (this.elem == null) {
			this.wait();
		}
		Integer res = this.elem;
		this.elem = null;
		this.notifyAll();
		return res;
	}
}
