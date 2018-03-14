package ru.demi.java_examples.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by demi
 * on 08.08.15.
 */
public class SendMail01 {
	public static void main(String[] args) throws IOException, MessagingException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("/media/demi/b4ca797e-825f-4cbc-879b-3344daf23a78/idd90/Java/JavaExamples/src/ru/demi/java_examples/mail/mail.properties"));
		Session session = Session.getDefaultInstance(properties);

		MimeMessage message = new MimeMessage(session);
		message.setSubject("Test mail from Java!");
		message.setText("Some content here");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("idd90y@yandex.ru"));
		message.setSentDate(new Date());

		// sending mail
		String userLogin = "idd90i@gmail.com";
		String userPwd = "Wb1990gmail";
		Transport transport = session.getTransport();

		// Error - gmail doesn't allow you to login here
//        transport.connect("smtp.gmail.com", 465, userLogin, userPwd);
//        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	}

}
