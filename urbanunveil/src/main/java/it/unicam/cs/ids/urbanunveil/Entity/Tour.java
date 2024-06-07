package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Tour {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne
	private User creator;
	@OneToMany
	private List<PointOfInterest> stops;
	
	public Tour (String n, List<PointOfInterest> s, User c) {
		name=n;
		creator=c;
		stops.addAll(s);
	}
	
	public Tour() {
	}
	
	
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void addStop(PointOfInterest s) {
		stops.add(s);
	}
	public void addStop(List<PointOfInterest> s) {
		stops.addAll(s);
	}
	
	public List<PointOfInterest> removeStop(PointOfInterest p) {
		stops.remove(p);
		return stops;
	}
	
	public List<PointOfInterest> removeStop(List<PointOfInterest>  s) {
		stops.removeAll(s);
		return stops;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PointOfInterest> getStops() {
		return stops;
	}
	public void setStops(List<PointOfInterest> stops) {
		this.stops = stops;
	}
	
}
