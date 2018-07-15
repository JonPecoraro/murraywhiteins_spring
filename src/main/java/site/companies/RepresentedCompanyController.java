package site.companies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="companies")
public class RepresentedCompanyController {
	@Autowired
	private RepresentedCompanyRepository representedCompanyRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCompanies(Model model) {
		model.addAttribute("companies", representedCompanyRepository.findAllByOrderBySortOrder());
		return "companies/index";
	}
}
