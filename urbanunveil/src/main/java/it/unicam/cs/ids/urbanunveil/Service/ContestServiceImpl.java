package it.unicam.cs.ids.urbanunveil.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Contest;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Repository.ContestRepository;

@Service
public class ContestServiceImpl implements ContestService { //Da Correggere quando viene aggiunta la factory
	
	
	private ContestRepository r;
	
	@Autowired
	public ContestServiceImpl(ContestRepository r) {
		this.r=r;
	}
	
	public ContestServiceImpl() {
	}

	@Override
	public Contest addContest(String n, LocalDate s, LocalDate e) {
		Contest c = new Contest(null, null, null, n, s, e);
		return r.save(c);
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
	public Contest updateContestById(Long i, String n, LocalDate s, LocalDate e) {
		Contest c = this.getContestById(i);
		c.setName(n);
		c.setStart(s);
		c.setEnd(e);
		return r.saveAndFlush(c);
	}

	@Override
	public Contest getContestById(Long i) {
		if(r.existsById(i)) {
			return r.getReferenceById(i);
		}
		return null;
	}
	
	@Override
	public Contest getContestByName(String n) {
		return r.findByName(n);
	}

	@Override
	public List<Contest> getAllContests() {
		return r.findAll();
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
		r.delete(c);
		return (r.findByName(n)) == null;
	}

	@Override
	public boolean removeContest(Long i) {
		Contest c = this.getContestById(i);
		r.delete(c);
		return r.existsById(i);
	}

	@Override
	public Contest updateContestByName(String n, LocalDate s, LocalDate e) {
		Contest c = this.getContestByName(n);
		r.delete(c);
		c.setStart(s);
		c.setEnd(e);
		return r.saveAndFlush(c);
	}

}
