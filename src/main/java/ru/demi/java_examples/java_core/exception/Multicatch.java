package ru.demi.java_examples.java_core.exception;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by demi
 * on 04.07.15.
 */
public class Multicatch {
	public static void main(String[] args) {
		try {
			if (System.nanoTime() % 2 == 0) {
				throw new IOException();
			} else {
				throw new SQLException();
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
