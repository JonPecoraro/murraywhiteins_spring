package site.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="users/admin")
public class UserAdminController {
	private static final Logger logger = LoggerFactory.getLogger(UserAdminController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showIndexPage(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users/adminView";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam(value="id", required=false) Integer id, Model model) {
		User user = null;
		if (id == null) {
			user = new User();
			user.setDateCreated(new java.sql.Date(new Date().getTime()));
		}
		else {
			user = userRepository.findOne(id);
		}
		user.setDateUpdated(new java.sql.Date(new Date().getTime()));
		
		model.addAttribute("user", user);
		return "users/update";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute User user, @RequestParam String confirmPassword, Model model) {
		User currentUser = userRepository.findOne(user.getId());;
		if (currentUser == null) {
			currentUser = user;
		}
		currentUser.setDateUpdated(user.getDateUpdated());
		currentUser.setEmail(user.getEmail());
		currentUser.setName(user.getName());
		
		if (user.getPassword().length() > 0) {
			List<String> errors = validatePassword(user.getPassword(), confirmPassword);
			if (errors.size() > 0) {
				model.addAttribute("user", user);
				model.addAttribute("error", true);
				model.addAttribute("errors", errors);
				return "users/update";
			}
			
			currentUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		
		userRepository.save(currentUser);
		return "redirect:/users/admin";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value="id") Integer id, Model model) {
		try {
			userRepository.delete(id);
			logger.info("Deleted user with ID " + id + " from the website.");
		} catch (IllegalArgumentException e) {
			logger.error("Unable to delete user", e);
		}
		return "redirect:/users/admin";
	}

	private List<String> validatePassword(String password, String confirmPassword) {
		List<String> errors = new ArrayList<>();
		if (!password.equals(confirmPassword)) {
			errors.add("Passwords don't match");
		}
		if (password.length() < 8) {
			errors.add("Password must be at least 8 characters long");
		}
		if (!password.matches(".*[0-9]+.*"))
		{
			errors.add("Password must contain at least one number");
		}
		if (!password.matches(".*[a-zA-Z]+.*"))
		{
			errors.add("Password must contain at least one letter");
		}
		if (!password.matches(".*[^a-zA-Z0-9 ]+.*"))
		{
			errors.add("Password must contain at least one special character");
		}
		return errors;
	}
}
