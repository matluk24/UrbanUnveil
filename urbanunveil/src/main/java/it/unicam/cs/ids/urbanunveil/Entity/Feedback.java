package it.unicam.cs.ids.urbanunveil.Entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;

import it.unicam.cs.ids.urbanunveil.Utilities.FeedbackEnum;

public class Feedback {

	private Long id;
	@ManyToMany
	private Content content;
	@OneToMany
	private User user;
	private LocalDate date;
	private String desc;
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
