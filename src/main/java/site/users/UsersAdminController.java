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
public class UsersAdminController {
	private static final Logger logger = LoggerFactory.getLogger(UsersAdminController.class);
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showIndexPage(Model model) {
		model.addAttribute("users", usersRepository.findAll());
		return "users/adminView";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam(value="id", required=false) Integer id, Model model) {
		Users users = null;
		if (id == null) {
			users = new Users();
			users.setDateCreated(new java.sql.Date(new Date().getTime()));
		}
		else {
			users = usersRepository.findOne(id);
		}
		users.setDateUpdated(new java.sql.Date(new Date().getTime()));
		
		model.addAttribute("user", users);
		return "users/update";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute Users users, @RequestParam String confirmPassword, Model model) {
		Users currentUser = usersRepository.findOne(users.getId());;
		if (currentUser == null) {
			currentUser = users;
		}
		currentUser.setDateUpdated(users.getDateUpdated());
		currentUser.setEmail(users.getEmail());
		currentUser.setName(users.getName());
		
		if (users.getPassword().length() > 0) {
			List<String> errors = validatePassword(users.getPassword(), confirmPassword);
			if (errors.size() > 0) {
				model.addAttribute("user", users);
				model.addAttribute("error", true);
				model.addAttribute("errors", errors);
				return "users/update";
			}
			
			currentUser.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		}
		
		usersRepository.save(currentUser);
		return "redirect:/users/admin";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value="id") Integer id, Model model) {
		try {
			usersRepository.delete(id);
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
