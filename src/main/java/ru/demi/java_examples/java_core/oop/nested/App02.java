package ru.demi.java_examples.java_core.oop.nested;

/**
 * Created by demi
 * on 13.07.15.
 */
public class App02 {
	int k;

	public void f() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println(k);
			}
		};
		r.run();
		/**
		 * It will be compiled
		 *
		 *   class App02$1 implements Runnable {
		 App02$1(App02 this$0) {
		 this.this$0 = this$0;
		 }

		 public void run() {
		 System.out.println(this.this$0.k);
		 }
		 }
		 */
	}

	public static void main(String[] args) {
		new App02().f();
	}
}
