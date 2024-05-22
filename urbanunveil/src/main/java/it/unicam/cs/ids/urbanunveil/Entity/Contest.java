package it.unicam.cs.ids.urbanunveil.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Contest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long contestid;
	private LocalDate startingDate;
	private LocalDate endingDate;
	@OneToMany
	private List<User> partecipants;
	public LocalDate getStart() {
		return startingDate;
	}
	public void setStart(LocalDate start) {
		this.startingDate = start;
	}
	public LocalDate getEnd() {
		return endingDate;
	}
	public void setEnd(LocalDate end) {
		this.endingDate = end;
	}
	public List<User> getPartecipants() {
		return partecipants;
	}
	public void setPartecipants(List<User> partecipants) {
		this.partecipants = partecipants;
	}
}
