package ru.demi.java_examples.java_core.exception;

import java.io.IOException;

/**
 * Created by demi
 * on 15.07.15.
 */
public class Finally04 {
	public static void main(String[] args) throws IOException {
		System.out.println(f());
	}

	public static int f() throws IOException {
		try {
			throw new RuntimeException();
		} finally {
			throw new IOException();
		}
	}
}
