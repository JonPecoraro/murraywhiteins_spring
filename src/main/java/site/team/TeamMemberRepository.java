package site.team;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring

public interface TeamMemberRepository extends CrudRepository<TeamMember, Integer> {
	Iterable<TeamMember> findByImageNotNull();
	Iterable<TeamMember> findByImageNull();
}
