package site.team;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
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
			member.setImage("/img/team/no_image.jpg");
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
			teamMemberRepository.delete(id);
			logger.info("Deleted user with ID " + id + " from the website.");
		} catch (IllegalArgumentException e) {
			logger.error("Unable to delete user", e);
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
				if (relativePath == null || relativePath == "" || relativePath.equals("/img/team/no_image.jpg")) {
					relativePath = "/img/team/" + teamMember.getFirstName().toLowerCase() + "_" + teamMember.getLastName().toLowerCase() + ".jpg";
					teamMember.setImage(relativePath);
				}
				SaveNewProfilePictureToFileSystem(profilePicture, relativePath);
			}
			catch(Exception e) {
				logger.error("There was an error updating the profile picture in the file system", e);
			}
		}
		if (profilePictureLarge != null && profilePictureLarge.getSize() > 0) {
			// A new large profile picture was passed in. Update it in the file system
			try {
				String relativePath = teamMember.getLargeImageUrl();
				if (relativePath == null || relativePath == "" || relativePath.equals("/img/team/no_image.jpg")) {
					relativePath = "/img/team/" + teamMember.getFirstName().toLowerCase() + "_" + teamMember.getLastName().toLowerCase() + "_large.jpg"; 
				}
				SaveNewProfilePictureToFileSystem(profilePictureLarge, relativePath);
			}
			catch(Exception e) {
				logger.error("There was an error updating the large profile picture in the file system", e);
			}
		}
		teamMemberRepository.save(teamMember);
		return "redirect:/team/admin";
	}
	
	private void SaveNewProfilePictureToFileSystem(MultipartFile profilePicture, String relativeImagePath) throws URISyntaxException, IOException {	
		URL staticContentUrl = this.getClass().getClassLoader().getResource("static");
		URL fullUrl = new URL(staticContentUrl, "static" + relativeImagePath);
		Path profilePicturePath = Paths.get(fullUrl.toURI());
		logger.info("profile picture path: " + profilePicturePath);
		Files.copy(profilePicture.getInputStream(), profilePicturePath, StandardCopyOption.REPLACE_EXISTING);
	}
}
