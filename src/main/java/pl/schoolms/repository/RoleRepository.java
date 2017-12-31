package pl.schoolms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.schoolms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findById(Long id);
	
}
