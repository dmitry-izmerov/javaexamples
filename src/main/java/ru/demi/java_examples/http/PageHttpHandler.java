package ru.demi.java_examples.http;

import com.sun.net.httpserver.*;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by demi
 * on 16.07.15.
 */
public class PageHttpHandler implements HttpHandler {
	private final String html;

	public PageHttpHandler(String html) {
		this.html = html;
	}

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		httpExchange.sendResponseHeaders(200, html.length());
		OutputStream out = httpExchange.getResponseBody();
		out.write(html.getBytes(StandardCharsets.US_ASCII));
		out.close();
	}
}
