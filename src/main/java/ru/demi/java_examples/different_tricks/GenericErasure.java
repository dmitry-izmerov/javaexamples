package ru.demi.java_examples.different_tricks;

import java.util.Arrays;
import java.util.List;

/**
 * @author demi
 * @date 21.12.16
 */
public class GenericErasure<T> {
	private final T first;
	private final T second;

	public GenericErasure(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T first() {
		return first;
	}

	public T second() {
		return second;
	}

	public List<String> stringList() {
		return Arrays.asList(String.valueOf(first), String.valueOf(second));
	}

	public static void main(String[] args) throws Exception {
//        GenericErasure<Object> p = new GenericErasure<Object>("Java", 24);
		GenericErasure p = new GenericErasure<Object>("Java", 24);
		for (Object s : p.stringList()) {
			System.out.print(s + " ");
		}
	}
}
