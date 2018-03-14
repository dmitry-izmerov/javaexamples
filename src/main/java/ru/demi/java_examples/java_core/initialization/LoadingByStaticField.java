package ru.demi.java_examples.java_core.initialization;

/**
 * @author demi
 * @date 08.01.17
 */
public class LoadingByStaticField {

	static class Super {
		static String ID = "QBANK";
	}

	static class Sub extends Super {
		static {
			System.out.print("In Sub");
		}
	}

	public static void main(String[] args) {
		System.out.println(Sub.ID);

		System.out.println("thread is "
			+ Thread.currentThread().getName());
	}
}
