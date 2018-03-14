package ru.demi.java_examples.java_core.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author demi
 * @date 06.01.17
 */
public class PriorityQueueExample {
	public static void main(String[] args) {
		Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
		Queue<Integer> intQueue = new PriorityQueue<>(10, comparator);
		intQueue.add(4);
		intQueue.add(3);
		intQueue.add(1);
		Integer[] intArray = new Integer[intQueue.size()];
		intQueue.toArray(intArray);
		intQueue.forEach(System.out::println);

		Arrays.sort(intArray, comparator);
		for (int entry : intArray) {
			System.out.println(entry);
		}
	}
}
