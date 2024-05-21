package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;

public interface POIRepository extends JpaRepository<PointOfInterest, Long> {

}
