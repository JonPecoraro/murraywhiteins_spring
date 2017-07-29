package site.util;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import site.common.ICalEvent;

public class EmailUtil {		
	/*
	 * sender: The JavaMailSender from the controller who is sending the email
	 * to: A semicolon delimited list of email addresses to send the email to
	 * subject: Text to be displayed as the email subject
	 * body: HTML text string for the body of the email
	 */
	public static void sendEmail(JavaMailSender sender, String to, String subject, String body) throws Exception {
		sendEmail(sender, to, subject, body, null);
	}
	
	/*
	 * sender: The JavaMailSender from the controller who is sending the email
	 * to: A semicolon delimited list of email addresses to send the email to
	 * subject: Text to be displayed as the email subject
	 * body: HTML text string for the body of the email
	 * calendarEvent: Used for sending a meeting event with the email. Pass null if there is no event
	 */
	public static void sendEmail(JavaMailSender sender, String to, String subject, String body, ICalEvent calendarEvent) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		Multipart multipart = new MimeMultipart();
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html><body><h2>" + subject + "</h2><hr /><div>");
		builder.append(body);
		builder.append("</div></body></html>");
		
		String[] toEmails = to.split(";");
		helper.setTo(toEmails);
		helper.setFrom("Murray White Postmaster <postmaster@mg.murraywhiteins.com>");
		helper.setSubject(subject);
		
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(builder.toString(), "text/html; charset=utf-8");
		multipart.addBodyPart(messageBodyPart);
		
		if (calendarEvent != null && calendarEvent.getTitle() != null) {
			BodyPart calendarEventBodyPart = new MimeBodyPart();
			calendarEventBodyPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
			calendarEventBodyPart.setHeader("Content-ID",  "calendar_message");
			calendarEventBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(calendarEvent.toString(), "text/calendar")));
			
			multipart.addBodyPart(calendarEventBodyPart);
			
			message.addHeaderLine("method=REQUEST");
			message.addHeaderLine("component=VEVENT");
		}
		
		message.setContent(multipart);
		sender.send(message);
	}
}
