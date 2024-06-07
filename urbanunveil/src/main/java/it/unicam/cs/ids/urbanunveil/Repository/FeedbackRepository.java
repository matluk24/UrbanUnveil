package it.unicam.cs.ids.urbanunveil.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Feedback;
import it.unicam.cs.ids.urbanunveil.Entity.User;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	List<Feedback> findAllByDate(LocalDate d);
	List<Feedback> findAllByPublisher(User u);
	List<Feedback> findAllByContent(Content c);
}
