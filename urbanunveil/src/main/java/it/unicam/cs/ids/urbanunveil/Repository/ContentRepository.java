package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.cs.ids.urbanunveil.Entity.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
