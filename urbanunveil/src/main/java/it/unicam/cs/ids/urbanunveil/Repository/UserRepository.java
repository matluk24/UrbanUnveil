package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.unicam.cs.ids.urbanunveil.Entity.User;


public interface UserRepository extends JpaRepository<User,Long> {

}
