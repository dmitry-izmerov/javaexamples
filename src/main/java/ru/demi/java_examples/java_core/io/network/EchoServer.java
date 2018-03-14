package ru.demi.java_examples.java_core.io.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by demi
 * on 26.06.15.
 */
public class EchoServer {
	public static void main(String[] args) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(3000)) {
			// wait for client connection
			try (Socket incoming = serverSocket.accept()) {
				InputStream in = incoming.getInputStream();
				OutputStream out = incoming.getOutputStream();

				try (Scanner scanner = new Scanner(in)) {
					PrintWriter printWriter = new PrintWriter(out, true);
					printWriter.println("Hello, enter BYE to exit.");

					boolean isDone = false;
					while (!isDone && scanner.hasNextLine()) {
						String s = scanner.nextLine();
						printWriter.println("From server: " + s);
						if (s.trim().toUpperCase().equals("BYE")) {
							isDone = true;
						}
					}
				}
			}
		}
	}
}
