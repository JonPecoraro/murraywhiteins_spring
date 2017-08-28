package site.common;

import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring

public interface TestimonialRepository extends CrudRepository<Testimonial, Integer> {
	
}