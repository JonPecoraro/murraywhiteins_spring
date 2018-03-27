package site.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="team")
public class TeamMemberController {	
	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getTeamMemberIndex(Model model) {
		model.addAttribute("teamMembersWithImage", teamMemberRepository.findByImageNotNullOrderBySortOrder());
		model.addAttribute("teamMembersWithoutImage", teamMemberRepository.findByImageNullOrderBySortOrder());
		return "team/index";
	}
	
	@RequestMapping(value="/profile", params={"id"}, method=RequestMethod.GET)
	public String showProfile(@RequestParam("id") int id, Model model) {
		model.addAttribute("teamMember", teamMemberRepository.findOne(id));
		return "team/profile";
	}
}
