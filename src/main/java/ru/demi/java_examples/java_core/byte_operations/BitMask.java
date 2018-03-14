package ru.demi.java_examples.java_core.byte_operations;

/**
 * Created by demi
 * on 01.06.15.
 */
public class BitMask {
	public static void main(String[] args) {
		// save three number in one
		int age, height, weight, combined, mask;
		age = 25; // 00011001
		height = 183; // 10110111
		weight = 80; // 01010000
		combined = (age) | (height << 8) | (weight << 16); // 00000000 01010000 10110111 00011001
		System.out.println(Integer.toBinaryString(combined));

		mask = 0b11111111;

		System.out.printf("Age: %d, height: %d, weight: %d%n",
			combined & mask,
			combined >>> 8 & mask,
			combined >>> 16 & mask
		);

		// work with access rights
		final int EXECUTE = 1; // 001
		final int WRITE = 2;   // 010
		final int READ = 4;    // 100

		// give full access for user
		int userAccess = EXECUTE | WRITE | READ;
		System.out.println(Integer.toBinaryString(userAccess));

		// take away right WRITE
		userAccess = userAccess ^ WRITE;
		// or usersAccess = usersAccess & ~EXECUTE
		System.out.println(Integer.toBinaryString(userAccess));
	}
}
