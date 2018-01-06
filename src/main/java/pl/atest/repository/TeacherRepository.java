package pl.atest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.atest.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	Teacher findById(Long id);	
	
}
