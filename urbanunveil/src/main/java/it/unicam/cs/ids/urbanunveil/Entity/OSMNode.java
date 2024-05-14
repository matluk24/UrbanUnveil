package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.Map;

public class OSMNode {

	private Long id;
	private double lat;
	private double lon;
	private Map<String, String> tags;
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
	public Map<String, String> getTags() {
		return tags;
	}
	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "OSMNode [id=" + id + ", lat=" + lat + ", lon=" + lon + ", tags=" + tags + "]";
	}
}
