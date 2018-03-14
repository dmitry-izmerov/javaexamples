package ru.demi.java_examples.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by demi
 * on 16.07.15.
 */
public class HttpHandler implements Callable<Void> {
	private final Socket socket;

	public HttpHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public Void call() throws IOException {
		try (InputStream in = socket.getInputStream()) {
			OutputStream out = socket.getOutputStream();
			byte[] request = HttpUtils.readRequestFully(in);
			System.out.println(new String(request, "ISO-8859-1"));
			byte[] response = HttpUtils.createResponse(new Date().toString());
			System.out.println(new String(response, "ISO-8859-1"));
			out.write(response);
		} finally {
			socket.close();
		}
		return null;
	}
}
