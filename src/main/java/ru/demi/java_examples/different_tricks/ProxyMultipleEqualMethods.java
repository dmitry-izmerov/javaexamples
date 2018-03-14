package ru.demi.java_examples.different_tricks;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author demi
 * @date 21.12.16
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html">Proxy doc</a>
 * <p>
 * Therefore, when a duplicate method is invoked on a proxy instance,
 * the Method object for the method in the foremost interface that contains
 * the method (either directly or inherited through a superinterface)
 * in the proxy class's list of interfaces is passed to the invocation
 * handler's invoke method, regardless of the reference type through which the method invocation occurred.
 */
public class ProxyMultipleEqualMethods {
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

		B proxy = (B) Proxy.newProxyInstance(
			B.class.getClassLoader(), new Class[]{A.class, B.class}, handler);

		proxy.method();
	}
}

interface A {
	void method();
}

interface B {
	void method();
}
