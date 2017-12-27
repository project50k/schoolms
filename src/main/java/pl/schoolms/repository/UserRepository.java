package pl.schoolms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.schoolms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);
	
}
