package ru.demi.java_examples.java_core.statics;

/**
 * @author demi
 * @date 10.01.17
 */
public class GetStaticFiledByNullReference {
	static String name = "Himalaya";

	static GetStaticFiledByNullReference getNullRef() {
		System.out.println("Getting Name ");
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getNullRef().name);
	}
}
