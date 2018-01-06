package pl.atest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.atest.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findById(Long id);
	
}
