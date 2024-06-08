package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.cs.ids.urbanunveil.Entity.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

	Media findByTitle(String title);
}
