package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.Tour;
import it.unicam.cs.ids.urbanunveil.Entity.User;

public interface TourService {

	public Tour addTour(String n, List<PointOfInterest> s, User c);
	public boolean removeTour(Long i);
	public Tour updateTour(Long i, String n, List<PointOfInterest> s);
	public Tour addStop(Long i, PointOfInterest p);
	public Tour addStop(Long i, List<PointOfInterest> s);
	public Tour removeStop(Long i, PointOfInterest p);
	public Tour removeStop(Long i, List<PointOfInterest> s);
	public List<Tour> getAllTours();
	public List<Tour> getAllUserTours(User u);
	public Tour getTourById(Long i);
	public Tour getTourByName(String n);
}
	