package pl.atest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.atest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findById(Long id);
		
	@Query("SELECT s FROM Student s WHERE s.division = null")
	List<Student>sqlFindAllWithoutDivision();
	
//	@Query("SELECT s FROM Student s WHERE s.division_id = ?1")
//	List<Student>sqlFindAllInGroup(Long id);
	
	
	
	@Query(value = "SELECT * FROM student WHERE division_id = ?1", nativeQuery = true)
	List<Student>sqlFindAllInGroup(Long id);
}
