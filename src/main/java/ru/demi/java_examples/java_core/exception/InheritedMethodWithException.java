package ru.demi.java_examples.java_core.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author demi
 * @date 04.01.17
 */
public class InheritedMethodWithException {

	// Its not compiled!!!
    /*public static class SuperClass {
        public void start() throws IOException {
            throw new IOException("Not able to open file");
        }
    }
    public static class SubClass extends SuperClass{
        public void start() throws Exception {
            throw new Exception("Not able to start");
        }
    }*/

	// Можно лишь сужать класс исключения в наследнике
	private static class SuperClass {
		public void start() throws IOException {
			throw new IOException("Not able to open file");
		}
	}

	private static class SubClass extends SuperClass {
		public void start() throws FileNotFoundException {
			// FileNotFoundException - наследник IOException
			throw new FileNotFoundException("Not able to start");
		}
	}
}
