package it.unicam.cs.ids.urbanunveil.Entity;

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
}
