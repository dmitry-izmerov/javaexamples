package ru.demi.java_examples.java_core.enumeration;

/**
 * @author demi
 * @date 11.12.16
 */
public class EnumWithInheritance {

	enum Status {
		GREEN(1) {
			public int compute() {
				return value * 100;
			}
		},
		YELLOW(2) {
			public int compute() {
				return value;
			}
		};

		int value;

		Status(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public abstract int compute();
	}

	public static void main(String[] args) {
		System.out.println(Status.GREEN.getClass() + ", superclass - " + Status.GREEN.getClass().getSuperclass());
		System.out.println(Status.YELLOW.getClass() + ", superclass - " + Status.YELLOW.getClass().getSuperclass());
	}
}
