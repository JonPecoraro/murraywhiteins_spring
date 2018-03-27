package site.companies;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring

public interface RepresentedCompanyRepository extends CrudRepository<RepresentedCompany, Integer> {
	Iterable<RepresentedCompany> findAllByOrderBySortOrder();
	Iterable<RepresentedCompany> findByIdIn(Collection<Integer> ids);
}
