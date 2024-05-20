package it.unicam.cs.ids.urbanunveil.Entity;

import java.time.LocalDate;
import java.util.List;

public class Contest {

	private Long id;
	private LocalDate start;
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	public List<User> getPartecipants() {
		return partecipants;
	}
	public void setPartecipants(List<User> partecipants) {
		this.partecipants = partecipants;
	}
	private LocalDate end;
	private List<User> partecipants;
}
