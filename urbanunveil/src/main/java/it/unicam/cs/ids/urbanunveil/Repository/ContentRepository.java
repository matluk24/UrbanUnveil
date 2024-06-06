package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.cs.ids.urbanunveil.Entity.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}
