package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.cs.ids.urbanunveil.Entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
