package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@OneToMany(fetch = FetchType.EAGER)
	private List<PointOfInterest> stops;
	
	public Tour (String n, List<PointOfInterest> s, User c) {
		name=n;
		creator=c;
		stops=s;
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
		System.out.println(p);
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
	public Long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(creator, id, name, stops);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		return Objects.equals(creator, other.creator) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(stops, other.stops);
	}

	@Override
	public String toString() {
		return "Tour [id=" + id + ", name=" + name + ", creator=" + creator + ", stops=" + stops + "]";
	}
	
}
