package it.unicam.cs.ids.urbanunveil.Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import it.unicam.cs.ids.urbanunveil.Utilities.POIEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "content_id") 
public class Contest extends Content {

	private String name;
	private LocalDate startingDate;
	private LocalDate endingDate;
	@OneToMany
	private List<User> partecipants;
	
	public Contest (String d, User u, List<Media> m, String n, LocalDate s, LocalDate e) {
		super(d, u, m);
		name=n;
		startingDate=s;
		endingDate=e;
	}
	
	public Contest() {
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	
	public void setPartecipants(User p) {
		partecipants.add(p);
	}

	@Override
	public String toString() {
		return "Contest [name=" + name + ", startingDate=" + startingDate + ", endingDate=" + endingDate
				+ ", partecipants=" + partecipants + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(endingDate, name, partecipants, startingDate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contest other = (Contest) obj;
		return Objects.equals(endingDate, other.endingDate) && Objects.equals(name, other.name)
				&& Objects.equals(partecipants, other.partecipants) && Objects.equals(startingDate, other.startingDate);
	}

	
}
