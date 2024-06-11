package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class OSMNode{

	private Long id;
	private double lat;
	private double lon;
	private String name;
	
	public OSMNode(Long id, double latitude, double longitude, String name) {
		this.id = id;
		this.lat =latitude;
		this.lon = longitude;
		this.name = name;
	}
	
	public OSMNode() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "OSMNode [id=" + id + ", lat=" + lat + ", lon=" + lon + ", nome="+ name +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lat, lon, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		OSMNode other = (OSMNode) obj;
		return Objects.equals(id, other.id) && Double.doubleToLongBits(lat) == Double.doubleToLongBits(other.lat)
				&& Double.doubleToLongBits(lon) == Double.doubleToLongBits(other.lon)
				&& Objects.equals(name, other.name);
	}
	
}
