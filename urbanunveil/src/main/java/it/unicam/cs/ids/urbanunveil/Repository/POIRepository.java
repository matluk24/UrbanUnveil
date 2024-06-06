package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;

@Repository
public interface POIRepository extends JpaRepository<PointOfInterest, Long> {

}
