package it.unicam.cs.ids.urbanunveil.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;

import it.unicam.cs.ids.urbanunveil.Utilities.FeedbackEnum;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Content content;
	@ManyToOne
	private User publisher;
	private LocalDate date;
	private String desc;
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public User getUser() {
		return publisher;
	}
	public void setUser(User publisher) {
		this.publisher = publisher;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public FeedbackEnum getType() {
		return type;
	}
	public void setType(FeedbackEnum type) {
		this.type = type;
	}
	private FeedbackEnum type;
}
