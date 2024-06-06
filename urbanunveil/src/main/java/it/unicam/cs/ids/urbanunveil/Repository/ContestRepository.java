package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.cs.ids.urbanunveil.Entity.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long> {

	Contest findByName(String name); 
}
