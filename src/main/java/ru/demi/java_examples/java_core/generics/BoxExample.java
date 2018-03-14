package ru.demi.java_examples.java_core.generics;

import java.util.ArrayList;

/**
 * @author demi
 * @date 07.01.17
 */
public class BoxExample {
	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.set("some string");
		System.out.println(box.get());

		Box<? super Number> numberBox = new Box<>();
		numberBox.set(1);
		numberBox.set(1.1f);
		numberBox.set(1.2);
		System.out.println(numberBox.get());

		// raw type
		ArrayList list = new ArrayList();
		list.add("String"); // get the warning
	}

	private static class Box<E> {
		private E val;

		public E get() {
			return val;
		}

		public void set(E val) {
			this.val = val;
		}

		private <T> T process() {
			return (T) val;
		}

		private <t, E> t process(t item, E element) {
			return (t) element;
		}
	}
}
