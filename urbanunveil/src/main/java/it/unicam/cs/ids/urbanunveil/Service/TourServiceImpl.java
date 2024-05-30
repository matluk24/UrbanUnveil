package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.Tour;
import it.unicam.cs.ids.urbanunveil.Entity.User;

@Service
public class TourServiceImpl implements TourService {

	@Override
	public Tour addTour(String n, List<PointOfInterest> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeTour(Long i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tour updateTour(String n, List<PointOfInterest> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour addStop(PointOfInterest p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour addStop(List<PointOfInterest> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour removeStop(PointOfInterest p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour removeStop(List<PointOfInterest> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tour> getAllTours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tour> getAllUserTours(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour getTourById(Long i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour getTourByName(String n) {
		// TODO Auto-generated method stub
		return null;
	}

}
