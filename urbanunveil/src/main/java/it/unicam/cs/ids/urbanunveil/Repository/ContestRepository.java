package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.cs.ids.urbanunveil.Entity.Contest;

public interface ContestRepository extends JpaRepository<Contest, Long> {

	Contest findByName(String name); 
}
