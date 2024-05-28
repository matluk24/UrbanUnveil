package it.unicam.cs.ids.urbanunveil.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Contest;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Repository.ContestRepository;

@Service
public class ContestServiceImpl implements ContestService {
	
	private ContestRepository r;

	@Override
	public Contest addContest(String n, LocalDate s, LocalDate e) {
		Contest c = new Contest(n, s, e);
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
		r.delete(c);
		c.setName(n);
		c.setStart(s);
		c.setEnd(e);
		return r.save(c);
	}

	@Override
	public Contest getContestById(Long i) {
		return r.getReferenceById(i);
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
		// TODO Auto-generated method stub
		return null;
	}

}
