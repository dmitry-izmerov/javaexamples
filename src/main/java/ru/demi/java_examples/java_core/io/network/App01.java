package ru.demi.java_examples.java_core.io.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by demi
 * on 26.06.15.
 */
public class App01 {
	public static void main(String[] args) throws IOException {
		try (Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
			InputStream is = socket.getInputStream();
			Scanner scanner = new Scanner(is);

			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
	}
}
