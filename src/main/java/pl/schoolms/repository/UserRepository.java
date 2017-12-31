package pl.schoolms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.schoolms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);
	User findById(Long id);
	List<User>findByRolesId(long roles);
//	//-------------------------------------------
//	User findByUsername(String username);
//	//-------------------------------------------
//	User findById(Long id);
//	//-------------------------------------------
}
