package site.team;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring

public interface TeamMemberRepository extends CrudRepository<TeamMember, Integer> {
	Iterable<TeamMember> findByImageNotNullOrderBySortOrder();
	Iterable<TeamMember> findByImageNullOrderBySortOrder();
	Iterable<TeamMember> findByIdIn(Collection<Integer> ids);
}
