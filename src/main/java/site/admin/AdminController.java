package site.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.team.TeamMember;

@Controller
@RequestMapping(path="admin")
public class AdminController {	
	@RequestMapping(value= {"", "/", "index"}, method=RequestMethod.GET)
	public String getAdminIndex(Model model) {
		model.addAttribute("teamMember", new TeamMember());
		return "admin/index";
	}
	
	@RequestMapping(value="cancel", method=RequestMethod.POST)
	public String cancelQuote(Model model) {
		return "redirect:/admin/index";
	}
}
