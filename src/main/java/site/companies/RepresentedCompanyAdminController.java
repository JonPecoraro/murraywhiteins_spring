package site.companies;

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
			RepresentedCompany company = new RepresentedCompany();
			company.setImage("/logos/no_logo.jpg");
			model.addAttribute("company", company);
		}
		else {
			RepresentedCompany company = representedCompanyRepository.findOne(id);
			model.addAttribute("company", company);
		}
		return "companies/update";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteCompany(@RequestParam(value="id") Integer id, Model model) {
		try {
			RepresentedCompany company = representedCompanyRepository.findOne(id);
			representedCompanyRepository.delete(id);
			S3Util.deleteFile(company.getImage());
			logger.info("Deleted company with ID " + id + " from the website.");
		} catch (IllegalArgumentException e) {
			logger.error("Unable to delete company", e);
		}
		return "redirect:/companies/admin";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute RepresentedCompany company, @RequestParam(value="logo", required=false) MultipartFile logo) {
		logger.info("Saving company");
		if (logo != null && logo.getSize() > 0) {
			// A new company logo was passed in. Update it in the file system
			try {
				String relativePath = company.getImage();
				if (relativePath == null || relativePath == "" || relativePath.equals("/logos/no_logo.jpg")) {
					relativePath = "/logos/" + company.getNameInCamelCase() + ".jpg";
					company.setImage(relativePath);
				}
				S3Util.uploadFile(logo, relativePath);
			}
			catch(Exception e) {
				logger.error("There was an error updating the company logo in the file system", e);
			}
		}
		
		Date now = new Date(Calendar.getInstance().getTime().getTime());
		company.setDateCreated(now);
		company.setDateUpdated(now);
		representedCompanyRepository.save(company);
		return "redirect:/companies/admin";
	}
}
