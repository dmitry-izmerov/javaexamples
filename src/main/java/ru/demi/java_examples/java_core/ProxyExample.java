package ru.demi.java_examples.java_core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author demi
 * @date 08.01.17
 */
public class ProxyExample {

	interface A {
		void method();
	}

	interface B {
		void method();
	}

	public static void main(String[] args) throws Throwable {
		InvocationHandler handler = new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (Arrays.asList(A.class.getMethods()).contains(method))
					System.out.println("A");
				else
					System.out.println("B");
				return null;
			}
		};

		A proxy = (A) Proxy.newProxyInstance(B.class.getClassLoader(), new Class[]{A.class, B.class}, handler);
		proxy.method();

		B proxy2 = (B) Proxy.newProxyInstance(B.class.getClassLoader(), new Class[]{A.class, B.class}, handler);
		proxy2.method();
	}
}