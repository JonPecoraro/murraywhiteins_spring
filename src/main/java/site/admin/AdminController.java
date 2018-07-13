package site.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import site.common.Testimonial;
import site.common.TestimonialRepository;

@Controller
@RequestMapping(path="admin")
public class AdminController {
	private final int GLOBAL_MESSAGE_ID = 1;
	
	@Autowired
	private TestimonialRepository testimonialRepository;
	
	@Autowired
	private GlobalMessageRepository globalMessageRepository;
	
	@RequestMapping(value= {"", "/", "index"}, method=RequestMethod.GET)
	public String getAdminIndex(Model model) {
		return "admin/index";
	}
	
	@RequestMapping(value="imageCropUtility", method=RequestMethod.GET)
	public String showImageCropUtility(Model model) {
		return "admin/imageCropUtility";
	}
	
	@RequestMapping(value="addTestimonial", method=RequestMethod.GET)
	public String showAddTestimonialPage(Model model) {
		return "admin/addTestimonial";
	}
	
	@RequestMapping(value="globalMessage", method=RequestMethod.GET)
	public String showGlobalMessageConfigPage(Model model) {
		GlobalMessage globalMessage = globalMessageRepository.findOne(GLOBAL_MESSAGE_ID);
		if (globalMessage == null) {
			globalMessage = new GlobalMessage();
		}
		model.addAttribute("globalMessage", globalMessage);
		return "admin/globalMessage";
	}
	
	@RequestMapping(value="saveTestimonial", params = {"author", "testimonial"}, method=RequestMethod.POST)
	public String saveTestimonial(String author, String testimonial) {
		Testimonial testimonialObject = new Testimonial();
		testimonialObject.setAuthor(author);
		testimonialObject.setTestimonial(testimonial);
		testimonialRepository.save(testimonialObject);
		return "redirect:/admin/index";
	}
	
	@RequestMapping(value="saveGlobalMessage", method=RequestMethod.POST)
	public String saveGlobalMessage(@ModelAttribute GlobalMessage message) {
		globalMessageRepository.save(message);
		return "redirect:/admin/index";
	}
	
	@RequestMapping(value="cancel", method=RequestMethod.POST)
	public String cancelQuote(@RequestParam(value="page", required=false) String page) {
		if (page != null)
		{
			return "redirect:" + page;
		}
		else
		{
			return "redirect:/admin/index";
		}
	}
}
