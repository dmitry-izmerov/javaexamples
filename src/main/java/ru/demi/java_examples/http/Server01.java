package ru.demi.java_examples.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by demi
 * on 16.07.15.
 */
public class Server01 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8090);
		while (true) {
			System.out.println("Wait for TCP-connection...");
			// TODO what are accept doing?
			Socket socket = serverSocket.accept();
			System.out.println("get request!");
			try (InputStream in = socket.getInputStream()) {
				OutputStream out = socket.getOutputStream();
				byte[] request = HttpUtils.readRequestFully(in);
				System.out.println(" =========================== ");
				System.out.println(new String(request, "ISO-8859-1"));
				System.out.println(" =========================== ");
				byte[] response = new Date().toString().getBytes("ISO-8859-1");
				out.write(response);
			} finally {
				socket.close();
			}
		}
	}
}
