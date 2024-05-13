package it.unicam.cs.ids.urbanunveil.Entity;

import jakarta.persistence.*;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;

@Entity
public class Content {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@ManyToOne
	private User publisher;
	private StateEnum state;
	private String descr;
	//private List<Media> medias;  //Creazione classe Media
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
	/*public List<Media> getSources() {
		return medias;
	}
	public void setSources(List<Media> medias) {
		this.medias = medias;
	}
	*/
	@Override
	public String toString() {
		return "Content [Id=" + Id + ", state=" + state + ", descr=" + descr + "]";
	}

	
	
}
