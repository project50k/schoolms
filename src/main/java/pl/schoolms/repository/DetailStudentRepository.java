package pl.schoolms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.schoolms.entity.DetailStudent;

public interface DetailStudentRepository extends JpaRepository<DetailStudent, Long>{
	
	DetailStudent findById(Long id);
	
}
