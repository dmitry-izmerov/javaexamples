package ru.demi.java_examples.java_core.wrappers;

/**
 * @author demi
 * @date 08.01.17
 */
public class VarargAndWrapper {
	static void methodA(Integer... i) {
		System.out.println("A");
	}

	static void methodA(int... i) {
		System.out.println("B");
	}

	public static void main(String[] args) {
//        methodA(Integer.valueOf("5"));
//        methodA(new int[]{1, 2, 3});
	}

	// Пояснение: При использовании методов с var-arg аргументами, которые перегружены как для примитивов,
	// так и для оболочек (wrapper), в качестве параметров можно передавать только массивы.
}
