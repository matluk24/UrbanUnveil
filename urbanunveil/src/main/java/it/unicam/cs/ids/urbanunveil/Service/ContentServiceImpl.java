package it.unicam.cs.ids.urbanunveil.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.ContentRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;
import it.unicam.cs.ids.urbanunveil.Utilities.NotInWaitingStateException;

@Service
public class ContentServiceImpl implements ContentService{
	
	ContentRepository r;

	@Override
	public Content getContentById(Long i) {
		if(r.existsById(i)) {
			return r.getReferenceById(i);
		}
		return null;
	}

	@Override
	public List<Content> getAllContents() {
		return r.findAll();
	}

	@Override
	public Content addContent(String d, User p, List<Media> m) {
		Content c = new Content(d, p, m);
		return r.save(c);
	}

	@Override
	public StateEnum getContentState(Long i) {
		return this.getContentById(i).getState();
	}

	@Override
	public boolean changeContentStateToApproved(Long i) throws NotInWaitingStateException {
		Content c = this.getContentById(i);
		if(c.getState().equals(StateEnum.WAITING)) {
			c.setState(StateEnum.APPROVED);
			return true;
		}
		throw new NotInWaitingStateException();
	}

	@Override
	public boolean changeContentStateToRefused(Long i) throws NotInWaitingStateException {
		Content c = this.getContentById(i);
		if(c.getState().equals(StateEnum.WAITING)) {
			c.setState(StateEnum.REFUSED);
			return true;
		}
		throw new NotInWaitingStateException();
	}

	@Override
	public List<Content> getAllWaitingContent() {
		List<Content> waiting = new LinkedList<Content>();
		for (Content c : r.findAll())  {
			if (c.getState().equals(StateEnum.WAITING)) {
				waiting.add(c);
			}
		}
		return waiting;
	}

	@Override
	public List<Content> getAllApprovedContent() {
		List<Content> approved = new LinkedList<Content>();
		for (Content c : r.findAll())  {
			if (c.getState().equals(StateEnum.APPROVED)) {
				approved.add(c);
			}
		}
		return approved;
	}

	@Override
	public List<Content> getAllRefusedContent() {
		List<Content> refused = new LinkedList<Content>();
		for (Content c : r.findAll())  {
			if (c.getState().equals(StateEnum.REFUSED)) {
				refused.add(c);
			}
		}
		return refused;
	}

	@Override
	public Content updateContent(Long i, String d, Media m) {
		Content c = this.getContentById(i);
		r.delete(c);
		c.setDescr(d);
		c.addMedias(m);
		return r.save(c);
	}
	
	@Override
	public boolean removeContent(Long i) {
		r.deleteById(i);
		return r.existsById(i);
	}

}
