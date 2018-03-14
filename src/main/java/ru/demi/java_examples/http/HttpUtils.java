package ru.demi.java_examples.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by demi
 * on 16.07.15.
 */
public class HttpUtils {
	public static byte[] readRequestFully(InputStream in) throws IOException {
		byte[] buff = new byte[8192];
		int headerLen = 0;
		while (true) {
			int count = in.read(buff, headerLen, buff.length - headerLen);
			if (count < 0) {
				throw new RuntimeException("Connection is closed.");
			} else {
				headerLen += count;
				if (isRequestEnd(buff, headerLen)) {
					return Arrays.copyOfRange(buff, 0, headerLen);
				}
				if (headerLen == buff.length) {
					throw new RuntimeException("Too large HTTP request.");
				}
			}
		}
	}

	private static boolean isRequestEnd(byte[] request, int length) {
		if (request.length < 4) {
			return false;
		}

		return request[length - 4] == '\r' &&
			request[length - 3] == '\n' &&
			request[length - 2] == '\r' &&
			request[length - 1] == '\n';
	}

	public static byte[] createResponse(String content) {
		String html = "" +
			"<html>" +
			"<body>" +
			"<p>" +
			content +
			"</p>" +
			"</body>" +
			"</html>";
		return html.getBytes();
	}
}
