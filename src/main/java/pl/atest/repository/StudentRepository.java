package pl.atest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.atest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findById(Long id);
	
	@Query("SELECT s FROM Student s WHERE s.teacher = null")
	List<Student>sqlFindByHasTeacher();
	
}
