package ru.demi.java_examples.java_core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author demi
 * @date 07.01.17
 */
public class RawTypeExample {

	public static void main(String[] args) {
		List rawList = new ArrayList();
		List<String> list = new ArrayList<>();

		rawList = list; // Ok
		list = rawList; // Warning here
		rawList.add(8);

		String s = list.get(0); // ClassCastException
	}
}
