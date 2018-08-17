package site.team;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import site.util.S3Util;

@Controller
@RequestMapping(path="team/admin")
public class TeamMemberAdminController {
	private static final Logger logger = LoggerFactory.getLogger(TeamMemberAdminController.class);
	
	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getTeamMemberIndex(Model model) {
		model.addAttribute("teamMembersWithImage", teamMemberRepository.findByImageNotNullOrderBySortOrder());
		model.addAttribute("teamMembersWithoutImage", teamMemberRepository.findByImageNullOrderBySortOrder());
		return "team/adminView";
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
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam(value="id", required=false) Integer id, Model model) {
		String selectedSuffix = "";
		if (id == null) {
			TeamMember member = new TeamMember();
			member.setImage("/team/no_image.jpg");
			model.addAttribute("teamMember", member);
		}
		else {
			TeamMember member = teamMemberRepository.findOne(id);
			model.addAttribute("teamMember", member);
			selectedSuffix = member.getSuffix();
		}
		model.addAttribute("selectedSuffix", selectedSuffix);
		model.addAttribute("suffixOptions", new String[] {"", "Sr.", "Jr.", "III", "IV", "V"});
		return "team/update";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value="id") Integer id, Model model) {
		try {
			TeamMember teamMember = teamMemberRepository.findOne(id);
			teamMemberRepository.delete(id);
			S3Util.deleteFile(teamMember.getImage());
			S3Util.deleteFile(teamMember.getLrageImagePath());
			logger.info("Deleted team member with ID " + id + " from the website.");
		} catch (IllegalArgumentException e) {
			logger.error("Unable to delete team member", e);
		}
		return "redirect:/team/admin";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute TeamMember teamMember, @RequestParam(value="profilePicture", required=false) MultipartFile profilePicture, @RequestParam(value="profilePictureLarge", required=false) MultipartFile profilePictureLarge) {
		logger.info("Saving team member");
		if (profilePicture != null && profilePicture.getSize() > 0) {
			// A new profile picture was passed in. Update it in the file system
			try {
				String relativePath = teamMember.getImage();
				if (relativePath == null || relativePath == "" || relativePath.equals("/team/no_image.jpg")) {
					relativePath = "/team/" + teamMember.getFirstName().toLowerCase() + "_" + teamMember.getLastName().toLowerCase() + ".jpg";
					teamMember.setImage(relativePath);
				}
				S3Util.uploadFile(profilePicture, relativePath);
			}
			catch(Exception e) {
				logger.error("There was an error updating the profile picture", e);
			}
		}
		if (profilePictureLarge != null && profilePictureLarge.getSize() > 0) {
			// A new large profile picture was passed in. Update it in the file system
			try {
				String relativePath = teamMember.getLrageImagePath();
				if (relativePath == null || relativePath == "" || relativePath.equals("/team/no_image.jpg")) {
					relativePath = "/team/" + teamMember.getFirstName().toLowerCase() + "_" + teamMember.getLastName().toLowerCase() + "_large.jpg"; 
				}
				S3Util.uploadFile(profilePicture, relativePath);
			}
			catch(Exception e) {
				logger.error("There was an error updating the large profile picture", e);
			}
		}
		
		Date now = new Date(Calendar.getInstance().getTime().getTime());
		teamMember.setDateCreated(now);
		teamMember.setDateUpdated(now);
		teamMemberRepository.save(teamMember);
		return "redirect:/team/admin";
	}
}
