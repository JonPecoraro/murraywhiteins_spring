package site.quotes;

import java.time.Year;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.common.StateRepository;
import site.quotes.forms.AutoQuoteForm;
import site.quotes.forms.BusinessQuoteForm;
import site.quotes.forms.FloodQuoteForm;
import site.quotes.forms.HomeownersQuoteForm;
import site.quotes.forms.LifeQuoteForm;
import site.quotes.forms.OtherQuoteForm;
import site.quotes.forms.RentersQuoteForm;
import site.quotes.forms.UmbrellaQuoteForm;
import site.util.EmailUtil;

@Controller
@RequestMapping(path="quotes")
public class QuoteController {
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${email.to}")
	private String emailTo;
	
	@RequestMapping(value= {"", "/", "index"}, method=RequestMethod.GET)
	public String getQuoteIndex(Model model) {
		return "quotes/index";
	}
	
	@RequestMapping(value ="/type", params = {"type"}, method=RequestMethod.GET)
	public String getQuoteType(@RequestParam("type") String quoteType, Model model) {
		String view = "quotes/index";
		model.addAttribute("currentYear", Year.now().getValue());
		if (quoteType.equals("auto")) {
			model.addAttribute("states", stateRepository.findAll());
			model.addAttribute("quoteForm", new AutoQuoteForm());
			view = "quotes/auto";
		} else if (quoteType.equals("specialEvents")) {
			view = "redirect:https://services.usli.com/InstantQuote/?id=4709&templateID=53&mode=spe";
		} else if (quoteType.equals("homeowners")) {
			model.addAttribute("quoteForm", new HomeownersQuoteForm());
			view = "quotes/homeowners";
		} else if (quoteType.equals("umbrella")) {
			model.addAttribute("quoteForm", new UmbrellaQuoteForm());
			view = "quotes/umbrella";
		} else if (quoteType.equals("life")) {
			model.addAttribute("quoteForm", new LifeQuoteForm());
			view = "quotes/life";
		} else if (quoteType.equals("renters")) {
			model.addAttribute("quoteForm", new RentersQuoteForm());
			view = "quotes/renters";
		} else if (quoteType.equals("flood")) {
			model.addAttribute("quoteForm", new FloodQuoteForm());
			view = "quotes/flood";
		} else if (quoteType.equals("business")) {
			model.addAttribute("quoteForm", new BusinessQuoteForm());
			view = "quotes/business";
		} else if (quoteType.equals("other")) {
			model.addAttribute("quoteForm", new OtherQuoteForm());
			view = "quotes/other";
		}
		
		return view;
	}
	
	@RequestMapping(value = "/submitAuto", method=RequestMethod.POST)
	public String submitAuto(@Valid @ModelAttribute("quoteForm") AutoQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("currentYear", Year.now().getValue());
			return "quotes/auto";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Auto", quoteForm.toEmailString(), redirectAttributes);
				
		redirectAttributes.addFlashAttribute("success", true);
		return "redirect:/quotes/index";
	}
	
	@RequestMapping(value = "/submitHomeowners", method=RequestMethod.POST)
	public String submitAuto(@Valid @ModelAttribute("quoteForm") HomeownersQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "quotes/homeowners";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Homeowners", quoteForm.toEmailString(), redirectAttributes);
		
		return "redirect:/quotes/index";
	}
	
	@RequestMapping(value = "/submitUmbrella", method=RequestMethod.POST)
	public String submitAuto(@Valid @ModelAttribute("quoteForm") UmbrellaQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "quotes/umbrella";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Umbrella", quoteForm.toEmailString(), redirectAttributes);
		
		return "redirect:/quotes/index";
	}
	
	@RequestMapping(value = "/submitLife", method=RequestMethod.POST)
	public String submitLife(@Valid @ModelAttribute("quoteForm") LifeQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "quotes/life";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Life", quoteForm.toEmailString(), redirectAttributes);
		
		return "redirect:/quotes/index";
	}
	
	@RequestMapping(value = "/submitRenters", method=RequestMethod.POST)
	public String submitRenters(@Valid @ModelAttribute("quoteForm") RentersQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "quotes/renters";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Renters", quoteForm.toEmailString(), redirectAttributes);
		
		return "redirect:/quotes/index";
	}
	
	@RequestMapping(value = "/submitFlood", method=RequestMethod.POST)
	public String submitFlood(@Valid @ModelAttribute("quoteForm") FloodQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "quotes/flood";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Flood", quoteForm.toEmailString(), redirectAttributes);
		
		return "redirect:/quotes/index";
	}
	
	@RequestMapping(value = "/submitBusiness", method=RequestMethod.POST)
	public String submitBusiness(@Valid @ModelAttribute("quoteForm") BusinessQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "quotes/business";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Business", quoteForm.toEmailString(), redirectAttributes);
		
		return "redirect:/quotes/index";
	}

	@RequestMapping(value = "/submitOther", method=RequestMethod.POST)
	public String submitOther(@Valid @ModelAttribute("quoteForm") OtherQuoteForm quoteForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "quotes/other";
		}
		
		// No errors, send email and return to view
		emailQuoteRequest("Insurnace", quoteForm.toEmailString(), redirectAttributes);
		
		return "redirect:/quotes/index";
	}
	
	@RequestMapping(value="cancel", method=RequestMethod.POST)
	public String cancelQuote(Model model) {
		return "redirect:/quotes/index";
	}
	
	private void emailQuoteRequest(String quoteType, String emailBody, RedirectAttributes redirectAttributes) {
		try {
			String title = "New " + quoteType + " Quote Request"; 
			EmailUtil.sendEmail(sender, emailTo, title, emailBody);
			redirectAttributes.addFlashAttribute("success", true);
		} catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error", "There was a problem sending your quote request. Plase contact us directly at murraywhite@murraymwhiteinc.com.<br>" + ex);
		}
	}
}