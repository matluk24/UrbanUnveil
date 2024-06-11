package it.unicam.cs.ids.urbanunveil.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Feedback;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.FeedbackRepository;
import it.unicam.cs.ids.urbanunveil.Repository.MediaRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.FeedbackEnum;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	private FeedbackRepository r;
	
	@Autowired
	public FeedbackServiceImpl (FeedbackRepository r) {
		this.r=r;
	}
	
	public FeedbackServiceImpl() {
		
	}
	
	@Override
	public Feedback addPositiveFeedback(User u, Content c, String desc) {
		Feedback f = new Feedback(u, LocalDate.now(), desc, c, FeedbackEnum.POSITIVE);
		return r.save(f);
	}

	@Override
	public Feedback addNegativeFeedback(User u, Content c, String desc) {
		Feedback f = new Feedback(u, LocalDate.now(), desc, c, FeedbackEnum.NEGATIVE);
		return r.save(f);
	}

	@Override
	public boolean removeFeedback(Long i) {
		Feedback f = this.getFeedbackById(i);
		r.delete(f);
		return r.existsById(i);
	}

	@Override
	public Feedback updateFeedback(Long i, String desc) {
		Feedback f = this.getFeedbackById(i);
		f.setDesc(desc);
		return r.saveAndFlush(f);
	}

	@Override
	public Feedback getFeedbackById(Long i) {
		if(r.existsById(i)) {
			return r.findById(i).get();
		}
		return null;
	}

	@Override
	public List<Feedback> getAllUserFeedbacks(User u) {
		return r.findAllByPublisher(u);
	}

	@Override
	public List<Feedback> getAllContentFeedbacks(Content c) {
		return r.findAllByContent(c);
	}

	@Override
	public List<Feedback> getAllNegativeFeedbacks(Content c) {
		List<Feedback> f = this.getAllContentFeedbacks(c);
		List<Feedback> result = new ArrayList<Feedback>();
		f.forEach((e) ->  {
			if(e.getType().equals(FeedbackEnum.NEGATIVE)) result.add(e);
		});
		return result;
	}

	@Override
	public List<Feedback> getAllPositiveFeedbacks(Content c) {
		List<Feedback> f = this.getAllContentFeedbacks(c);
		List<Feedback> result = new ArrayList<Feedback>();
		f.forEach((e) ->  {
			if(e.getType().equals(FeedbackEnum.NEGATIVE)) result.add(e);
		});
		return result;
	}

	@Override
	public List<Feedback> getFeedbacksByDate(Content c, LocalDate d) {
		List<Feedback> f = this.getAllContentFeedbacks(c);
		List<Feedback> result = new ArrayList<Feedback>();
		f.forEach((e) ->  {
			if(e.getDate().equals(d)) result.add(e);
		});
		return result;
	}

}
