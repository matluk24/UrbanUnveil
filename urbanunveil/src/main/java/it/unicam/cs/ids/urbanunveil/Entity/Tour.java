package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tour {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany
	private List<PointOfInterest> stops;
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
