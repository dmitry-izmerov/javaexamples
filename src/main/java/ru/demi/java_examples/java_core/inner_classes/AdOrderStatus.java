package ru.demi.java_examples.java_core.inner_classes;

public class AdOrderStatus {
	private Long id = 11L;

	public void foo(Long id) {
		int g = 1;
		class Foo {
			void boo() {
				System.out.println(AdOrderStatus.this.id);
				System.out.println(g);
			}
		}
		new Foo().boo();
	}

	public static void main(String[] args) {
		new AdOrderStatus().foo(10L);
	}
}