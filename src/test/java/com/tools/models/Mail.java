package com.tools.models;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class Mail {

	public String veryfyMail(String subject) {
		String resultString = "";
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		props.setProperty("mail.imaps.port", "993");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("mail.evozon.com", "marian.mihai@evozon.com", "OlimpiA17@");
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			Message msgs[] = inbox.getMessages();
			System.out.println("messages.length---" + msgs.length);

			for (Message msg : msgs) {
				if (msg.getSubject().contains(subject))
					if (msg.getContentType().contains("multipart")) {
						Multipart mp = (Multipart) msg.getContent();
						BodyPart bp = mp.getBodyPart(0);

						resultString = String.valueOf(bp.getContent());
					} else {
						resultString = String.valueOf(msg.getContent());

					}
			}
		} catch (Exception mex) {
			mex.printStackTrace();
		}

		return resultString;
	}
}
