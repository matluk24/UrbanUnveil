package it.unicam.cs.ids.urbanunveil.Entity;

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
	@Override
	public String toString() {
		return "OSMNode [id=" + id + ", lat=" + lat + ", lon=" + lon + ", nome="+ name +"]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
