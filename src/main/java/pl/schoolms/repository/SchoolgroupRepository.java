package pl.schoolms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.schoolms.entity.Schoolgroup;

public interface SchoolgroupRepository extends JpaRepository<Schoolgroup, Long> {

	Schoolgroup findById(Long id);

}
