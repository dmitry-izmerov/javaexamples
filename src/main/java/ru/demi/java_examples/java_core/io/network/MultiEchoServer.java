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
public class MultiEchoServer {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(3000)) {
			while (true) {
				Socket incoming = serverSocket.accept();
				Runnable task = new ServerEchoTask(incoming);
				Thread thread = new Thread(task);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class ServerEchoTask implements Runnable {
		private Socket incoming;

		public ServerEchoTask(Socket incoming) {
			this.incoming = incoming;
		}

		@Override
		public void run() {
			try {
				try {
					InputStream in = incoming.getInputStream();
					OutputStream out = incoming.getOutputStream();

					Scanner scanner = new Scanner(in);
					PrintWriter printWriter = new PrintWriter(out, true);

					printWriter.println("Welcome to Echo Java Server!");
					printWriter.println("Enter Bye to exit from here.");

					boolean isDone = false;
					while (!isDone && scanner.hasNextLine()) {
						String s = scanner.nextLine();
						printWriter.println("FROM SERVER: " + s);
						if (s.trim().equalsIgnoreCase("bye")) {
							isDone = true;
						}
					}
				} finally {
					incoming.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
