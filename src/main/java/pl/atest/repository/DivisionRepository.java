package pl.atest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.atest.entity.Division;

public interface DivisionRepository extends JpaRepository<Division, Long>{
	
	Division findById(Long id);

	
}
