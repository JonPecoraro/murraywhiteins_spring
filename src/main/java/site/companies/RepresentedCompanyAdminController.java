package site.companies;

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
@RequestMapping(path="companies/admin")
public class RepresentedCompanyAdminController {
private static final Logger logger = LoggerFactory.getLogger(RepresentedCompanyAdminController.class);
	
	@Autowired
	private RepresentedCompanyRepository representedCompanyRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getTeamMemberIndex(Model model) {
		model.addAttribute("companies", representedCompanyRepository.findAllByOrderBySortOrder());
		return "companies/adminView";
	}
	
	@RequestMapping(value="/sort", params={"ids[]"}, method=RequestMethod.GET)
	@ResponseBody
	public Boolean updateSortOrder(@RequestParam("ids[]") Integer[] ids) {
		List<Integer> companyIds = Arrays.asList(ids);
		Iterable<RepresentedCompany> companies = representedCompanyRepository.findByIdIn(companyIds);;
		for (RepresentedCompany company : companies)
		{
			int newSortOrder = companyIds.indexOf(company.getId()) + 1;
			company.setSortOrder(newSortOrder);
		}
		representedCompanyRepository.save(companies);
		
		return true;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam(value="id", required=false) Integer id, Model model) {
		if (id == null) {
			model.addAttribute("company", new RepresentedCompany());
		}
		else {
			RepresentedCompany company = representedCompanyRepository.findOne(id);
			model.addAttribute("company", company);
		}
		return "companies/update";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute RepresentedCompany company, @RequestParam(value="logo", required=false) MultipartFile logo) {
		logger.info("Saving company");
		if (logo != null && logo.getSize() > 0) {
			// A new company logo was passed in. Update it in the file system
			try {
				SaveNewLogoToFileSystem(logo, company.getImage());
			}
			catch(Exception e) {
				logger.error("There was an error updating the company logo in the file system", e);
			}
		}
		representedCompanyRepository.save(company);
		return "redirect:/companies/admin";
	}
	
	private void SaveNewLogoToFileSystem(MultipartFile logo, String relativeImagePath) throws URISyntaxException, IOException {	
		URL staticContentUrl = this.getClass().getClassLoader().getResource("static");
		URL fullUrl = new URL(staticContentUrl, "static" + relativeImagePath);
		Path logoPath = Paths.get(fullUrl.toURI());
		Files.copy(logo.getInputStream(), logoPath, StandardCopyOption.REPLACE_EXISTING);
	}
}
