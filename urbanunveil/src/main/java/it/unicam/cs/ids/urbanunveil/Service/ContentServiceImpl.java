package it.unicam.cs.ids.urbanunveil.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Contest;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.ContentRepository;
import it.unicam.cs.ids.urbanunveil.Repository.ContestRepository;
import it.unicam.cs.ids.urbanunveil.Repository.POIRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;
import it.unicam.cs.ids.urbanunveil.Utilities.NotInWaitingStateException;
import it.unicam.cs.ids.urbanunveil.Utilities.POIEnum;
import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;

@Service
public class ContentServiceImpl implements ContentService{
	
	private ContentRepository r;
	private POIRepository POIrepo;
	private ContestRepository contestRepo;
	
	@Autowired
	public ContentServiceImpl(ContentRepository r, POIRepository POIrepo, ContestRepository contestRepo) {
		this.r=r;
		this.POIrepo=POIrepo;
		this.contestRepo=contestRepo;
	}
	
	public ContentServiceImpl() {
		
	}
	
	@Override
	public Content getContentById(Long i) {
		if(r.existsById(i)) {
			return r.findById(i).get();
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
	public PointOfInterest addPOI(String d, User p, List<Media> m, OSMNode l, String type) {
		POIEnum t = POIEnum.valueOf(type);
		PointOfInterest c = new PointOfInterest(d, p, m, l, t);
		return POIrepo.save(c);
	}
	
	@Override
	public PointOfInterest addPOI(String d, User p, OSMNode l, String type) {
		POIEnum t = POIEnum.valueOf(type);
		PointOfInterest c = new PointOfInterest(d, p, l, t);
		return POIrepo.save(c);
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
			r.saveAndFlush(c);
			return true;
		}
		throw new NotInWaitingStateException();
	}

	@Override
	public boolean changeContentStateToRefused(Long i) throws NotInWaitingStateException {
		Content c = this.getContentById(i);
		if(c.getState().equals(StateEnum.WAITING)) {
			c.setState(StateEnum.REFUSED);
			r.saveAndFlush(c);
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
	public Content updateContent(Long i, String d, List<Media> m) {
		Content c = this.getContentById(i);
		c.setDescr(d);
		c.setMedia(m);
		return r.saveAndFlush(c);
	}
	
	@Override
	public boolean removeContent(Long i) {
		r.deleteById(i);
		return r.existsById(i);
	}
	


	@Override
	public Contest addContest(String d, User u, String n, LocalDate s, LocalDate e) {
		Contest c = new Contest(d, u, n, s, e);
		return contestRepo.save(c);
	}

	@Override
	public boolean isContestEnded(Long i) {
		if(this.getContestById(i).getEnd().compareTo(LocalDate.now())<0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isContestEnded(String n) {
		if(this.getContestByName(n).getEnd().compareTo(LocalDate.now())<0) {
			return true;
		}
		return false;
	}

	@Override
	public Contest updateContestById(Long i, String d, String n, LocalDate s, LocalDate e) {
		Contest c = this.getContestById(i);
		c.setName(n);
		c.setStart(s);
		c.setEnd(e);
		c.setDescr(d);
		return contestRepo.saveAndFlush(c);
	}
	
	@Override
	public Contest addPhotoToContest(Long i, Media m) {
		Contest c = this.getContestById(i);
		c.addPhoto(m);
		return contestRepo.saveAndFlush(c);
	}
	
	@Override
	public Contest addPhotoToContest(Long i, List<Media> m) {
		Contest c = this.getContestById(i);
		c.addPhoto(m);
		return contestRepo.saveAndFlush(c);
	}


	@Override
	public Contest getContestById(Long i) {
		if(contestRepo.existsById(i)) {
		return contestRepo.findById(i).get();
		}
		return null;
	}
	
	@Override
	public Contest getContestByName(String n) {
		return contestRepo.findByName(n);
	}

	@Override
	public List<Contest> getAllContests() {
		return contestRepo.findAll();
	}

	@Override
	public List<Media> getAllContestPhotosById(Long i) {
		return this.getContestById(i).getPhotos();
	}
	
	@Override
	public List<Media> getAllContestPhotosByName(String n) {
		return this.getContestByName(n).getPhotos();
	}

	@Override
	public boolean removeContest(String n) {
		Contest c = this.getContestByName(n);
		contestRepo.delete(c);
		return (contestRepo.findByName(n)) == null;
	}
	
	@Override
	public Contest removePhotoFromContest(Long i, Media m) {
		Contest c = this.getContestById(i);
		c.removePhoto(m);
		return contestRepo.saveAndFlush(c);
	}
	
	@Override
	public Contest removePhotoFromContest(Long i, List<Media> m) {
		Contest c = this.getContestById(i);
		c.removePhoto(m);
		return contestRepo.saveAndFlush(c);
	}


	@Override
	public boolean removeContest(Long i) {
		Contest c = this.getContestById(i);
		contestRepo.delete(c);
		return contestRepo.existsById(i);
	}

	@Override
	public Contest updateContestByName(String d, String n, LocalDate s, LocalDate e) {
		Contest c = this.getContestByName(n);
		contestRepo.delete(c);
		c.setStart(s);
		c.setEnd(e);
		c.setDescr(d);
		return contestRepo.saveAndFlush(c);
	}

	@Override
	public boolean removePOI(Long i) {
		if(POIrepo.existsById(i)) {
			POIrepo.deleteById(i);
			return true;
		}
		return false;
	}

}
