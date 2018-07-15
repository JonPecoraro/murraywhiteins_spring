package site.users;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
