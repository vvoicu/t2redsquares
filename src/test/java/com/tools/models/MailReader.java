package com.tools.models;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class MailReader {

	public void check(String host, String storeType, String user, String password) {
		try {

			Properties properties = new Properties();

			properties.put("mail.imaps.host", host);
			properties.put("mail.imaps.port", "993");
			properties.put("mail.store.protocol", "imaps");
			Session emailSession = Session.getDefaultInstance(properties);

			Store store = emailSession.getStore("imaps");

			store.connect(host, user, password);

			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			
			Flags seen = new Flags(Flags.Flag.SEEN);
		    FlagTerm unseenFlagTerm = new FlagTerm(seen, false);

			Message[] messages = emailFolder.search(unseenFlagTerm);
			if(messages.length==0){
				System.out.println("No unread messages!");
			}
			else{
			System.out.println("Number of unread messages: " + messages.length);
			}
			
			for (int i = 0; i < messages.length; i++) {
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");

				// Multipart mp = (Multipart) messages[i].getContent();
				// BodyPart bp = mp.getBodyPart(0);

				System.out.println("From: " + messages[i].getFrom()[0]);
				System.out.println("To: " + messages[i].getAllRecipients()[0]);
				System.out.println("Sent Date: " + messages[i].getSentDate());
				System.out.println("Subject: " + messages[i].getSubject());
				System.out.println("Text: " + messages[i].getContent());
				System.out.println("Text: " + getTextFromMessage(messages[i]));
			}
			emailFolder.close(false);
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTextFromMessage(Message message) throws Exception {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests.
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MailReader mr = new MailReader();
		String host = "mail.evozon.com";
		String mailStoreType = "imaps";
		String username = "attila.marton@evozon.com";
		String password = "Shippuuden9.";

		mr.check(host, mailStoreType, username, password);
	}
}