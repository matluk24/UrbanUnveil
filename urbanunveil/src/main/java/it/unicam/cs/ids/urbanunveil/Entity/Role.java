package it.unicam.cs.ids.urbanunveil.Entity;

import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;
import jakarta.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private RoleName roleName;
	private String description;
	
	public Role(int id, RoleName role, String description) {
		this.id= id;
		this.description = description;
		this.roleName = role;
		
	}
	
	public Long getId() {
		return this.id;
		}
	public RoleName getRole() {
		return this.roleName;
	}
	public String getDesctiption() {
		return this.description;
	}
	@Override
	public String toString() {
		return " id : "+this.id+
				"role :"+this.roleName+
				"description : "+this.description;
	}
	}
