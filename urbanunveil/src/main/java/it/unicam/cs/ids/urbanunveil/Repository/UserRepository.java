package it.unicam.cs.ids.urbanunveil.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.cs.ids.urbanunveil.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByEmail(String email);
	
}
