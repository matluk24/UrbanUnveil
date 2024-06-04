package it.unicam.cs.ids.urbanunveil.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.cs.ids.urbanunveil.Entity.Tour;
import it.unicam.cs.ids.urbanunveil.Entity.User;

public interface TourRepository extends JpaRepository<Tour, Long> {

	List<Tour> findAllByUser(User u);
	
	Tour findByName(String n);
}
