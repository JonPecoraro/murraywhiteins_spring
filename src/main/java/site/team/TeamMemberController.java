package site.team;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="team")
public class TeamMemberController {
	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getTeamMemberIndex(Model model) {
		model.addAttribute("teamMembersWithImage", teamMemberRepository.findByImageNotNullOrderBySortOrder());
		model.addAttribute("teamMembersWithoutImage", teamMemberRepository.findByImageNotNullOrderBySortOrder());
		return "team/index";
	}
	
	@RequestMapping(value="/profile", params={"id"}, method=RequestMethod.GET)
	public String showProfile(@RequestParam("id") int id, Model model) {
		model.addAttribute("teamMember", teamMemberRepository.findOne(id));
		return "team/profile";
	}
	
	@RequestMapping(value="/adminView", method=RequestMethod.GET)
	public String showAdminView(Model model) {
		model.addAttribute("teamMembersWithImage", teamMemberRepository.findByImageNotNullOrderBySortOrder());
		model.addAttribute("teamMembersWithoutImage", teamMemberRepository.findByImageNotNullOrderBySortOrder());
		return "team/adminView";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam(value="id", required=false) Integer id, Model model) {
		if (id == null) {
			model.addAttribute("teamMember", new TeamMember());
		}
		else {
			model.addAttribute("teamMember", teamMemberRepository.findOne(id));
		}
		return "team/update";
	}
	
	@RequestMapping(value="/sort", params={"ids[]"}, method=RequestMethod.GET)
	@ResponseBody
	public Boolean updateSortOrder(@RequestParam("ids[]") Integer[] ids) {
		List<Integer> teamMemberIds = Arrays.asList(ids);
		Iterable<TeamMember> teamMembers = teamMemberRepository.findByIdIn(teamMemberIds);
		for (TeamMember teamMember : teamMembers)
		{
			int newSortOrder = teamMemberIds.indexOf(teamMember.getId()) + 1;
			teamMember.setSortOrder(newSortOrder);
		}
		teamMemberRepository.save(teamMembers);
		
		return true;
	}
}
