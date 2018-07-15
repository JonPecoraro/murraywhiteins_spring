package site.admin;

import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring

public interface GlobalMessageRepository extends CrudRepository<GlobalMessage, Integer> {

}
