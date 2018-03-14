package ru.demi.java_examples.java_core.primitive;

/**
 * @author demi
 * @date 12.01.17
 */
public class CastingFromInfinity {
	public static void main(String[] args) {
		double p = Double.POSITIVE_INFINITY;
		double n = Double.NEGATIVE_INFINITY;


		System.out.println("======== Long ==========");
		System.out.println((long) p);
		System.out.println(Long.MAX_VALUE);
		System.out.println((long) n);
		System.out.println(Long.MIN_VALUE);
		System.out.println("========================");

		System.out.println("======= Integer ========");
		System.out.println((int) p);
		System.out.println(Integer.MAX_VALUE);
		System.out.println((int) n);
		System.out.println(Integer.MIN_VALUE);
		System.out.println("========================");

		System.out.println("======== Short =========");
		System.out.println((short) p);
		System.out.println(Short.MAX_VALUE);
		System.out.println((short) n);
		System.out.println(Short.MIN_VALUE);
		System.out.println("========================");

		System.out.println("========= Char =========");
		System.out.println((char) p);
		System.out.println(Character.MAX_VALUE);
		System.out.println((char) n);
		System.out.println(Character.MIN_VALUE);
		System.out.println("========================");

		System.out.println("========= Byte =========");
		System.out.println((byte) p);
		System.out.println(Byte.MAX_VALUE);
		System.out.println((byte) n);
		System.out.println(Byte.MIN_VALUE);
		System.out.println("========================");

		System.out.println((short) ((int) p));
		System.out.println((short) ((int) n));

		System.out.println(
			((long) p > (long) n) + " " +
				((int) p > (int) n) + " " +
				((short) p > (short) n) + " " +
				((char) p > (char) n) + " " +
				((byte) p > (byte) n)
		);

		/**
		 * Пояснение: Этот пример демонстрирует принцип преобразований вещественных типов в целые.
		 * Сначала приводится к int (или long), а потом просто урезается,
		 * если нужен byte, char или short. Из-за этого byte и short так странно себя ведут
		 * (например -inf -> 0x80000000 -> 0x00=0, а +inf -> 0x7FFFFFFF -> 0xFF=-1)
		 */
	}
}
