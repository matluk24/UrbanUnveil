package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.Objects;

import it.unicam.cs.ids.urbanunveil.Utilities.MediaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Media {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String path;
	private MediaEnum type;
	
	public Media() {
		
	}
	
	
	public Media(String path, String title, MediaEnum t) {
		this.path=path;
		this.title=title;
		type=t;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public MediaEnum getType() {
		return type;
	}


	public void setType(MediaEnum type) {
		this.type = type;
	}


	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", path=" + path + ", type=" + type + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, path, title, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		return Objects.equals(id, other.id) && Objects.equals(path, other.path) && Objects.equals(title, other.title)
				&& type == other.type;
	}
	
	
}
