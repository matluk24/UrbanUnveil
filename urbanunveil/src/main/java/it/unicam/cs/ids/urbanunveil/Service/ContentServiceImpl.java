package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.ContentRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;

public class ContentServiceImpl implements ContentService{
	
	ContentRepository r;

	@Override
	public Content getContentById(Long i) {
		return r.getReferenceById(i);
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
	public boolean changeContentStateToApproved(Long i) {
		Content c = this.getContentById(i);
		if(c.getState().equals(StateEnum.WAITING)) {
			c.setState(StateEnum.APPROVED);
			return true;
		}
		throw new stateNotInWaitingStateException();
		return false;
	}

	@Override
	public boolean changeContentStateToRefused(Long i) {
		Content c = this.getContentById(i);
		if(c.getState().equals(StateEnum.WAITING)) {
			c.setState(StateEnum.REFUSED);
			return true;
		}
		throw new stateNotInWaitingStateException();
		return false;
	}

	@Override
	public List<Content> getAllWaitingContent(StateEnum i) {
		return null;
	}

	@Override
	public List<Content> getAllApprovedContent(StateEnum i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Content> getAllRefusedContent(StateEnum i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Content updateContent(Long i, String d, Media m) {
		Content c = this.getContentById(i);
		r.delete(c);
		c.setDescr(d);
		c.addMedias(m);
		return r.save(c);
	}

}
