package pl.atest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.atest.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	
	Subject findById(Long id);

	
}
