package site.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="admin")
public class AdminController {	
	@RequestMapping(value= {"", "/", "index"}, method=RequestMethod.GET)
	public String getAdminIndex(Model model) {
		return "admin/index";
	}
	
	@RequestMapping(value= {"imageCropUtility"}, method=RequestMethod.GET)
	public String showImageCropUtility(Model model) {
		return "admin/imageCropUtility";
	}
	
	@RequestMapping(value="cancel", method=RequestMethod.POST)
	public String cancelQuote(@RequestParam(value="page", required=false) String page, Model model) {
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
