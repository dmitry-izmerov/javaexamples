package ru.demi.java_examples.http;

import com.sun.net.httpserver.*;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.spi.HttpServerProvider;
import sun.net.httpserver.DefaultHttpServerProvider;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by demi
 * on 16.07.15.
 */
public class Server03 {
	public static void main(String[] args) throws IOException {
		final int backlog = 64;
		final InetSocketAddress serverAddress = new InetSocketAddress(8090);

		HttpServerProvider provider = DefaultHttpServerProvider.provider();
		HttpServer server = provider.createHttpServer(serverAddress, backlog);
		server.setExecutor(Executors.newCachedThreadPool());

		HttpContext baseContext = server.createContext("/");
		baseContext.setHandler(new HttpHandler() {
			@Override
			public void handle(HttpExchange httpExchange) throws IOException {
				String protocol = httpExchange.getProtocol();
				String requestMethod = httpExchange.getRequestMethod();
				URI requestURI = httpExchange.getRequestURI();
				Headers headers = httpExchange.getRequestHeaders();

				String htmlPage = createResponsePage(protocol, requestMethod, requestURI, headers);

				Headers responseHeaders = httpExchange.getResponseHeaders();
				responseHeaders.add("X-CustomHeader", "1");
				responseHeaders.add("X-CustomHeader", "2");
				httpExchange.sendResponseHeaders(200, htmlPage.length());

				OutputStream out = httpExchange.getResponseBody();
				out.write(htmlPage.getBytes(StandardCharsets.US_ASCII));
				out.close();
			}
		});

		server.start();
	}

	private static String createResponsePage(String protocol, String requestMethod, URI requestURI, Headers headers) {
		String html = "<html>";
		html += "<body>";
		html += "<br>requestMethod: " + requestMethod + "<br>";
		html += "<br>requestURI: " + requestURI + "<br>";
		html += "<br>protocol: " + protocol + "<br>";

		for (Map.Entry<String, List<String>> headerEntry : headers.entrySet()) {
			String key = headerEntry.getKey();
			List<String> values = headerEntry.getValue();
			html += "<br>" + key + ": ";
			for (String value : values) {
				html += value + ", ";
			}
			html = html.trim();
			html = html.substring(0, html.length() - 1);
			html += "<br>";
		}
		html += "</body></html>";
		return html;
	}
}
