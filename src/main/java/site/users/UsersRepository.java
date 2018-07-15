package site.users;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring

public interface UsersRepository extends CrudRepository<Users, Integer> {
	Users findByEmail(String email);
}
