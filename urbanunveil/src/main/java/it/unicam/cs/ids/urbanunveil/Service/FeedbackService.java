package it.unicam.cs.ids.urbanunveil.Service;

import java.time.LocalDate;
import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Feedback;
import it.unicam.cs.ids.urbanunveil.Entity.User;;

public interface FeedbackService {

	public Feedback addPositiveFeedback(User u, Content c, String desc);
	public Feedback addNegativeFeedback(User u, Content c, String desc);
	public boolean removeFeedback(Long i);
	public Feedback updateFeedback(Long i, String desc);
	public Feedback getFeedbackById(Long i);
	public List<Feedback> getAllUserFeedbacks(User u);
	public List<Feedback> getAllContentFeedbacks(Content c);
	public List<Feedback> getAllNegativeFeedbacks();
	public List<Feedback> getAllPositiveFeedbacks();
	public List<Feedback> getFeedbacksByDate(LocalDate d);
	
}
