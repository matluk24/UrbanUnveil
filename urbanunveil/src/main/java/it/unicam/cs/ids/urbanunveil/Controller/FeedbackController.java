package it.unicam.cs.ids.urbanunveil.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Service.FeedbackService;
import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Feedback;
import it.unicam.cs.ids.urbanunveil.Entity.User;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	public FeedbackController(FeedbackService f) {
		feedbackService = f;
	}
	
	@GetMapping("/feedbacks/{c}")
	public ResponseEntity<List<Feedback>> getContentFeedbacks(@RequestParam Content c) {
		List<Feedback> f = feedbackService.getAllContentFeedbacks(c);
		return new ResponseEntity<List<Feedback>>(f, HttpStatus.OK);
	}
	
	@GetMapping("/feedbacks/{c}/{date}")
	public ResponseEntity<List<Feedback>> getContentFeedbacksByDate(@RequestParam Content c, @RequestParam LocalDate date) {
		List<Feedback> f = feedbackService.getFeedbacksByDate(c, date);
		return new ResponseEntity<List<Feedback>>(f, HttpStatus.OK);
	}
	
	@GetMapping("/feedbacks/{c}/negative")
	public ResponseEntity<List<Feedback>> getContentNegativeFeedbacks(@RequestParam Content c) {
		List<Feedback> f = feedbackService.getAllNegativeFeedbacks(c);
		return new ResponseEntity<List<Feedback>>(f, HttpStatus.OK);
	}
	
	@GetMapping("/feedbacks/{c}/positive")
	public ResponseEntity<List<Feedback>> getContentPositiveFeedbacks(@RequestParam Content c) {
		List<Feedback> f = feedbackService.getAllPositiveFeedbacks(c);
		return new ResponseEntity<List<Feedback>>(f, HttpStatus.OK);
	}
	
	@GetMapping("/feedbacks/{user}")
	public ResponseEntity<List<Feedback>> getAllUserFeedbacks(@RequestParam User user) {
		List<Feedback> f = feedbackService.getAllUserFeedbacks(user);
		return new ResponseEntity<List<Feedback>>(f, HttpStatus.OK);
	}
	
	@GetMapping("/feedbacks/{id}")
	public ResponseEntity<Feedback> getAllFeedbacks(@RequestParam Long id) {
		Feedback f = feedbackService.getFeedbackById(id);
		return new ResponseEntity<Feedback>(f, HttpStatus.OK);
	}
	
	@PostMapping("/feedbacks/{c}/addPositive")
	public ResponseEntity<Feedback> addPositiveFeedback(@RequestParam Content c, @RequestParam User u, @RequestParam String desc) {
		Feedback f = feedbackService.addPositiveFeedback(u, c, desc);
		return new ResponseEntity<Feedback>(f, HttpStatus.OK);
	}
	
	@PostMapping("/feedbacks/{c}/addNegative")
	public ResponseEntity<Feedback> addNegativeFeedback(@RequestParam Content c, @RequestParam User u, @RequestParam String desc) {
		Feedback f = feedbackService.addNegativeFeedback(u, c, desc);
		return new ResponseEntity<Feedback>(f, HttpStatus.OK);
	}
	
	@PostMapping("/feedbacks/update/{id}")
	public ResponseEntity<Feedback> updateFeedback(@RequestParam Long id, @RequestParam String desc) {
		Feedback f = feedbackService.updateFeedback(id, desc);
		return new ResponseEntity<Feedback>(f, HttpStatus.OK);
	}
	
	@DeleteMapping("/feedbacks/remove/{id}")
	public HttpStatus removeFeedback(@RequestParam Long id) {
		if(feedbackService.removeFeedback(id)) {
			return HttpStatus.OK;
		}
		else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
}
