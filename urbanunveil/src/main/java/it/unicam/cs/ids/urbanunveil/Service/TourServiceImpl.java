package it.unicam.cs.ids.urbanunveil.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.Tour;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.TourRepository;

@Service
public class TourServiceImpl implements TourService {
	
	TourRepository r;

	@Override
	public Tour addTour(String n, List<PointOfInterest> s, User c) {
		Tour t;
		if (s.isEmpty()) {	
			t = new Tour(n, new LinkedList<PointOfInterest>(), c);
		}
		else {
			t = new Tour(n, s, c);
		}
		return r.save(t);
	}

	@Override
	public boolean removeTour(Long i) {
		Tour t = this.getTourById(i);
		r.delete(t);
		return r.existsById(i);
	}

	@Override
	public Tour updateTour(Long i, String n, List<PointOfInterest> s) {
		Tour t = this.getTourById(i);
		r.delete(t);
		if(!n.equals(null)) {
			t.setName(n);
		}
		t.setStops(s);
		return r.saveAndFlush(t);
	}

	@Override
	public Tour addStop(Long i, PointOfInterest p) {
		Tour t = this.getTourById(i);
		t.addStop(p);
		return r.saveAndFlush(t);
	}

	@Override
	public Tour addStop(Long i, List<PointOfInterest> s) {
		Tour t = this.getTourById(i);
		t.addStop(s);
		return r.saveAndFlush(t);
	}

	@Override
	public Tour removeStop(Long i, PointOfInterest p) {
		Tour t = this.getTourById(i);
		if(t.getStops().contains(p)) {
			t.removeStop(p);
		}
		return r.saveAndFlush(t);
	}

	@Override
	public Tour removeStop(Long i, List<PointOfInterest> s) {
		Tour t = this.getTourById(i);
		if(t.getStops().containsAll(s)) {
			t.removeStop(s);
		}
		return r.saveAndFlush(t);
	}

	@Override
	public List<Tour> getAllTours() {
		return r.findAll();
	}

	@Override
	public List<Tour> getAllUserTours(User u) {
		return r.findAllByCreator(u);
	}

	@Override
	public Tour getTourById(Long i) {
		if(r.existsById(i)) {
			return r.getReferenceById(i);
		}
		return null;
	}

	@Override
	public Tour getTourByName(String n) {
		return r.findByName(n);
	}

}
