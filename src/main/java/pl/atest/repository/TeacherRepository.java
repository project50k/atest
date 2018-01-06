package pl.atest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.atest.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	Teacher findById(Long id);
	
	@Query("SELECT t FROM Teacher t WHERE t.student = null")
	List<Teacher>sqlFindByHasStudent();
	
	
}
