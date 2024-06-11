package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.List;
import java.util.Objects;

import it.unicam.cs.ids.urbanunveil.Utilities.POIEnum;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "content_id") 
public class PointOfInterest extends Content {

	@Embedded
	private OSMNode location;
	private POIEnum type;
	
	public PointOfInterest(String d, User u, OSMNode l, POIEnum t) {
		super(d, u);
		location=l;
		type=t;
	}
	
	public PointOfInterest(String d, User u, List<Media> m, OSMNode l, POIEnum t) {
		super(d, u, m);
		location=l;
		type=t;
	}
	
	public PointOfInterest() {
	}
	
	
	public OSMNode getLocation() {
		return location;
	}
	public void setLocation(OSMNode location) {
		this.location = location;
	}
	public POIEnum getType() {
		return type;
	}
	public void setType(POIEnum type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PointOfInterest [location=" + location + ", type=" + type + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(location, type);
		return result;
	}

	public boolean equals(PointOfInterest obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		PointOfInterest other = (PointOfInterest) obj;
		System.out.println(obj);
		System.out.println(other.getLocation().equals(location));
		return Objects.equals(location, other.location) && type == other.type;
	}
	
	
	
}
