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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.util.EmailUtil;

@Controller
@RequestMapping(path="contact")
public class ContactController {
	static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${email.to}")
	private String emailTo;
	
	@RequestMapping(value= {"", "/", "index"}, method=RequestMethod.GET)
	public String getContactIndex(Model model) {
		return "contact/index";
	}
	
	@RequestMapping(value="submitContactForm", params = {"firstName", "lastName", "email", "contactMessage"}, method=RequestMethod.POST)
	public String submitContactForm(String firstName, String lastName, String email, String contactMessage, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String emailInformation = "<p>";
		
		emailInformation += "<b>First name:</b> " + firstName + "<br />";
		emailInformation += "<b>Last name:</b> " + lastName + "<br />";
		emailInformation += "<b>Email address:</b> " + email + "<br />";
		emailInformation += "<b>Message:</b> " + contactMessage;
		emailInformation += "</p>";
		
		try {
			EmailUtil.sendEmail(sender, emailTo, "Website Contact Form Submitted", emailInformation, request.getRemoteAddr());
			redirectAttributes.addFlashAttribute("success", "Thank you for your feedback. We have received your message.");
		} catch(Exception ex) {
			logger.error("There was a problem sending the email message: {}", ex);
			redirectAttributes.addFlashAttribute("error", "There was a problem sending the email message. Plase contact us directly at murraywhite@murraymwhiteinc.com.<br>" + ex);
		}
		
		return "redirect:/contact/index";
	}
}
