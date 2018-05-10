package site.index;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.common.ICalEvent;
import site.util.EmailUtil;
import site.util.SmsUtil;

@Controller
@RequestMapping(path="")
public class IndexController {
	static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${email.to}")
	private String emailTo;
	
	@RequestMapping(value= {"", "/", "index"}, method=RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("timeIntervals", getTimeIntervals());
		model.addAttribute("appointmentForm", new AppointmentForm());
		return "index";
	}
	
	@RequestMapping(value="/submitAppointment", method=RequestMethod.POST)
	public String submitAppointment(@ModelAttribute("appointmentForm") AppointmentForm appointmentForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request) {		
		String dateString = appointmentForm.getAppointmentDate();
		String timeString = appointmentForm.getAppointmentTime();
		DateFormat dateFormat = new SimpleDateFormat();
		
		try {
			Date appointmentStartDate = dateFormat.parse(dateString + " " + timeString);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(appointmentStartDate);
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			
			Date appointmentEndDate = calendar.getTime();
			
			ICalEvent appointmentEvent = new ICalEvent(
				"Appointment with " + appointmentForm.getName(), 
				"A " + appointmentForm.getType() + " appointment with " + appointmentForm.getName() + " (" + appointmentForm.getPhone() + ")",
				appointmentStartDate,
				appointmentEndDate
			);
			
			SmsUtil.sendMessage("Appointment Request\n" + appointmentForm.toSmsString());
			EmailUtil.sendEmail(sender, emailTo, "New Appointment Request", appointmentForm.toEmailString(), request.getRemoteAddr(), appointmentEvent);
			
			// If user wants a copy of the appointment request emailed to them
			if (appointmentForm.getEmailUserAppointmentDetails()) {
				ICalEvent customerAppointmentEvent = new ICalEvent(
					"Appointment with Murray White Insurance Agency, Inc.", 
					"A " + appointmentForm.getType() + " appointment with Murray White Insurance Agency, Inc. (336-889-4747)",
					appointmentStartDate,
					appointmentEndDate
				);
				
				EmailUtil.sendEmail(sender, appointmentForm.getEmail(), "Appointment with Murray White Insurance Agency, Inc.", appointmentForm.toEmailString(), request.getRemoteAddr(), customerAppointmentEvent);
			}
			
			redirectAttributes.addFlashAttribute("success", true);
		} catch(Exception ex) {
			logger.error("There was a problem sending the email message: {}", ex);
			redirectAttributes.addFlashAttribute("error", "There was a problem sending the email message. Plase contact us directly at murraywhite@murraymwhiteinc.com.<br>" + ex);
		}
		
		return "redirect:/index";
	}
	
	private List<String> getTimeIntervals() {
		List<String> timeIntervals = new ArrayList<String>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		try {
			Date startTime = dateFormat.parse("7:30 AM");
			Date endTime = dateFormat.parse("4:00 PM");
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startTime);
			while (calendar.getTime().before(endTime)) {
				calendar.add(Calendar.MINUTE, 30);
				timeIntervals.add(dateFormat.format(calendar.getTime()));
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return timeIntervals;
	}
}
