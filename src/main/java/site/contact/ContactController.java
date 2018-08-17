package site.contact;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.common.ReCaptchaProcessor;
import site.util.EmailUtil;
import site.util.SmsUtil;

@Controller
@RequestMapping(path="contact")
public class ContactController {
	static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private ReCaptchaProcessor recaptchaProcessor;
	
	@Value("${email.to}")
	private String emailTo;
	
	@RequestMapping(value= {"", "/", "index"}, method=RequestMethod.GET)
	public String getContactIndex(Model model) {
		return "contact/index";
	}
	
	@RequestMapping(value="submitContactForm", params = {"firstName", "lastName", "email", "contactMessage", "protection", "g-recaptcha-response"}, method=RequestMethod.POST)
	public String submitContactForm(String firstName, String lastName, String email, String contactMessage, String protection, @RequestParam("g-recaptcha-response") String gReCaptchaResponse, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String emailInformation = generateEmailInformation(firstName, lastName, email, contactMessage);
		String smsInformation = generateSmsInformation(firstName, lastName, email, contactMessage);
		
		try {
			if (protection.isEmpty())
			{
				recaptchaProcessor.processResponse(gReCaptchaResponse);
				EmailUtil.sendEmail(sender, emailTo, "Website Contact Form Submitted", emailInformation, request.getRemoteAddr());
				SmsUtil.sendMessage(smsInformation);
			}
			redirectAttributes.addFlashAttribute("success", "Thank you for your feedback. We have received your message.");
		} catch(Exception ex) {
			logger.error("There was a problem sending the email or SMS message: {}", ex);
			redirectAttributes.addFlashAttribute("error", "There was a problem sending the message. Plase contact us directly at murraywhite@murraymwhiteinc.com.");
		}
		
		return "redirect:/contact/index";
	}
	
	private String generateEmailInformation(String firstName, String lastName, String email, String contactMessage) {
		String emailInformation = "<p>";
		emailInformation += "<b>First name:</b> " + firstName + "<br />";
		emailInformation += "<b>Last name:</b> " + lastName + "<br />";
		emailInformation += "<b>Email address:</b> " + email + "<br />";
		emailInformation += "<b>Message:</b> " + contactMessage;
		emailInformation += "</p>";
		
		return emailInformation;
	}

	private String generateSmsInformation(String firstName, String lastName, String email, String contactMessage) {
		String smsInformation = "murraywhiteins.com website contact form submitted" + "\n";
		smsInformation += "Name: " + firstName + " " + lastName + "\n";
		smsInformation += "Email: " + email + "\n";
		smsInformation += "Message: " + contactMessage;
		
		return smsInformation;
	}
}
