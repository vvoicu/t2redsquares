package com.tools.models;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class ReadMail {
	
	public void checkMail(String host, String username, String password){
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.port", "993");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, username, password);
            
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
              
         // search for all "unseen" messages     
//            Flags seen = new Flags(Flags.Flag.SEEN);
//            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
//            
//            Message messages[] = inbox.search(unseenFlagTerm);
//            if (messages.length == 0){
//            	System.out.println("No unread messages.");
//            }
//            	else{ 
//            		System.out.println("No. of Unread Messages : " + messages.length);
//            	}
//            
//            for(Message message:messages){
//            	if (message.getSubject().contains())
//            	     if (message.getContentType().contains("multipart")) {
//            	      Multipart mp = (Multipart) msg.getContent();
//            	      BodyPart bp = mp.getBodyPart(0);
//
//            	      resultString = String.valueOf(bp.getContent());
//            	     } else {
//            	      resultString = String.valueOf(message.getContent());
//            }
//            
            //last email from inbox
            Message messages[] =inbox.getMessages();
//            boolean mailFound=false;
            for (int i = messages.length-1; i>messages.length-2; i--){
            	System.out.println("=============================");
            	
            	System.out.println("FROM:" + messages[i].getFrom()[0]);
            	System.out.println("SENT DATE:" + messages[i].getSentDate());
            	System.out.println("SUBJECT:" + messages[i].getSubject());
            	System.out.println("CONTENT2:" + messages[i].getContentType());
            	System.out.println("CONTENT:" + getTextFromMessage(messages[i]));
            	
            
            }

        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
	
	// Part where content is separated as MimeType.
	public String getTextFromMessage(Message message) throws Exception {
		String result = "";
		if (message.isMimeType("text/*")) {
			result = message.getContent().toString();
			} 
			else if (message.isMimeType("multipart/*")) {
				MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
				result = getTextFromMimeMultipart(mimeMultipart);
			}
		return result;
	 }

	 // Part where content is read as MimeType.
	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests.
				} 
				else if (bodyPart.isMimeType("text/html")) {
					String html = (String) bodyPart.getContent();
					result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
					} 
					else if (bodyPart.getContent() instanceof MimeMultipart) {
						result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
					}
			}
		return result;
	 	}
	
	public static void main(String[] args){
		ReadMail rm = new ReadMail();
		String host = "mail.evozon.com";
		String username = "paula.klein@evozon.com";
		String password = "Steeltree20.";
		
		rm.checkMail(host, username, password);
	}
}

