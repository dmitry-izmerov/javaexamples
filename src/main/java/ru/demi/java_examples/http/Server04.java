package ru.demi.java_examples.http;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import sun.net.httpserver.DefaultHttpServerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by demi
 * on 16.07.15.
 */
public class Server04 {
	public static void main(String[] args) throws IOException {
		final int backlog = 64;
		final InetSocketAddress serverAddress = new InetSocketAddress(8090);

		HttpServerProvider provider = DefaultHttpServerProvider.provider();
		HttpServer server = provider.createHttpServer(serverAddress, backlog);

		HttpContext contextMain = server.createContext("/");
		String s = "<html>\n" +
			"<body>\n" +
			"<h1>Main page</h1>\n" +
			"<p><a href=\"/page1.html\">Page 1</a></p>" +
			"<p><a href=\"/page2.html\">Page 2</a></p>" +
			"</body>\n" +
			"</html>";
		contextMain.setHandler(new PageHttpHandler(s));

		HttpContext contextPageFirst = server.createContext("/page1.html");
		String s1 = "<html>\n" +
			"<body>\n" +
			"<h1>First page</h1>\n" +
			"<p><a href=\"/\">Main</a></p>" +
			"<p><a href=\"/page2.html\">Page 2</a></p>" +
			"</body>\n" +
			"</html>";
		contextPageFirst.setHandler(new PageHttpHandler(s1));

		HttpContext contextPageSecond = server.createContext("/page2.html");
		String s2 = "<html>\n" +
			"<body>\n" +
			"<h1>Second page</h1>\n" +
			"<p><a href=\"/\">Main</a></p>" +
			"<p><a href=\"/page1.html\">Page 1</a></p>" +
			"</body>\n" +
			"</html>";
		contextPageSecond.setHandler(new PageHttpHandler(s2));

		server.start();
	}
}
