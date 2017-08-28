package site.common;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	@Autowired
	TestimonialRepository testimonialRepository;
	
	@RequestMapping("/getTestimonial")
	public Testimonial getTestimonial() {
		int numTestimonials = (int)testimonialRepository.count();
		int randomTestimonialId = (new Random()).nextInt(numTestimonials) + 1;
		return testimonialRepository.findOne(randomTestimonialId);
	}
}
