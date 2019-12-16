package pe.gob.onp.orrhh.qr.service;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pe.gob.onp.orrhh.qr.utilitario.Constantes;


@Service
public class MailService {

	private final static Logger logger = LoggerFactory.getLogger(MailService.class);
	private static int noOfQuickServiceThreads = 20;
	static Properties mailServerProperties;
	static Session getMailSession;
	// static MimeMessage generateMailMessage;
	
	private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads);
	
	public void sendEmailGmailAccount(String emailTo, boolean iscc, List<String> emailCC, String emailBody,
			String subject, boolean attach, byte[] fileAttach, String filenameAttach, String fileExtension) throws AddressException, MessagingException {
		System.out.println("\n 1st=> Setup Mail Server Properties ");
		
		Message generateMailMessage;
		
		// Google
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
		if (iscc) {
			for (String data : emailCC) {
				generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(data));
				// generateMailMessage.addRecipient(Message.RecipientType.CC,
				// new InternetAddress(emailCC));
			}
		}
		generateMailMessage.setSubject(subject);
		BodyPart messageBodyPart1 = new MimeBodyPart(); 
		messageBodyPart1.setText(emailBody);
		messageBodyPart1.setContent(emailBody,"text/html");
		
		MimeBodyPart messageBodyPart2 = null;
		if(attach) {
			messageBodyPart2 = new MimeBodyPart();  
	        ByteArrayDataSource bds = new ByteArrayDataSource(fileAttach, "application/octet-stream"); 
	        messageBodyPart2.setDataHandler(new DataHandler(bds));
	        messageBodyPart2.setFileName(filenameAttach + "." + fileExtension);
	        
		}
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart1);  
		if(attach)
			multipart.addBodyPart(messageBodyPart2);
		
		 generateMailMessage.setContent(multipart);
		//generateMailMessage.setContent(emailBody, "text/html");
		// Send
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		quickService.submit(new Runnable() {
			@Override
			public void run() {
				try {
					Transport transport = getMailSession.getTransport("smtp");
					transport.connect(Constantes.GMAIL_HOST,
							Constantes.GMAIL_USERNAME,
							Constantes.GMAIL_PASSWORD);
					transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
					transport.close();
					System.out.println("Mail Session has been created successfully..");
				} catch (Exception e) {
					logger.error("Exception occur while send a mail: ", e);
				}
				
			}
		});
		
	}
	
	public static void sendVariosEmailGmailAccount(List<String> emailTo, boolean iscc, List<String> emailCC,
			String emailBody, String subject) throws AddressException, MessagingException {
		System.out.println("\n 1st=> Setup Mail Server Properties ");
		Message generateMailMessage;
		// Google
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);

		for (String dataTo : emailTo) {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(dataTo));
		}

		if (iscc) {
			for (String data : emailCC) {
				generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(data));
			}
		}
		generateMailMessage.setSubject(subject);
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect(Constantes.GMAIL_HOST,
				Constantes.GMAIL_USERNAME,
				Constantes.GMAIL_PASSWORD);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	
}
