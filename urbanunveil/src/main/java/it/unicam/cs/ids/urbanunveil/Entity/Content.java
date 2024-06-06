package it.unicam.cs.ids.urbanunveil.Entity;

import jakarta.persistence.*;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Content {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@ManyToOne
	private User publisher;
	private StateEnum state;
	private String descr;
	@OneToMany
	private List<Media> medias;  //Creazione classe Media
	
	public Content(String d, User u, List<Media> m) {
		descr=d;
		publisher=u;
		medias=m;
		state = StateEnum.WAITING;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	public StateEnum getState() {
		return state;
	}
	public void setState(StateEnum state) {
		this.state = state;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public List<Media> getMedias() {
		return medias;
	}
	public void addMedias(List<Media> medias) {
		this.medias.addAll(medias);
	}
	public void addMedias(Media m) {
		medias.add(m);
	}
	
	@Override
	public String toString() {
		return "Content [Id=" + Id + ", state=" + state + ", descr=" + descr + "]";
	}

	public void setMedia(List<Media> m) {
		medias = m;
	}

	
	
}
