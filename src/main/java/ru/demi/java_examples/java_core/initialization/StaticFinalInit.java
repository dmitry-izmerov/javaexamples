package ru.demi.java_examples.java_core.initialization;

/**
 * @author demi
 * @date 08.01.17
 */
public class StaticFinalInit {
	private static StaticFinalInit instance = new StaticFinalInit();
	private static final int DELTA = 6;
	private static int BASE = 7;
	private int x;

	private StaticFinalInit() {
		x = BASE + DELTA;
	}

	public static void main(String... argv) {
		System.out.println(StaticFinalInit.instance.x);
	}
}
