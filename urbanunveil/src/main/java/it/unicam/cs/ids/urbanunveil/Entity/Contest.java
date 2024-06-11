package it.unicam.cs.ids.urbanunveil.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Contest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate startingDate;
	private LocalDate endingDate;
	@OneToMany(fetch = FetchType.EAGER)
	private List<User> partecipants;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Media> photos;
	
	public Contest (String n, LocalDate s, LocalDate e) {
		name=n;
		startingDate=s;
		endingDate=e;
		partecipants=new ArrayList<User>();
		photos = new ArrayList<Media>();
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
	
	public List<Media> getPhotos() {
		return photos;
	}
	
	public void addPhoto(Media m) {
		photos.add(m);
	}
	
	public List<Media> removePhoto(Media m) {
		photos.remove(m);
		return photos;
	}
	
	public List<Media> removePhoto(List<Media> m) {
		photos.removeAll(m);
		return photos;
	}
	
	public void addPhoto(List<Media> m) {
		photos.addAll(m);
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
